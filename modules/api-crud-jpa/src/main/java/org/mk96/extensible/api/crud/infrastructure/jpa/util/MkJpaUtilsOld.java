package org.mk96.extensible.api.crud.infrastructure.jpa.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.crud.type.filter.MkFilterType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaUtilsOld {

	public Supplier<MkCrudException> error(String message) {
		return () -> new MkCrudException(message);
	}

	public final Predicate<Field> isIdField = (field) ->
		field.isAnnotationPresent(Id.class);

	public final Predicate<Field> isUniqueField = (field) -> {
		if (!field.isAnnotationPresent(Column.class)) {
            return false;
        }
		return field.getAnnotation(Column.class).unique();
	};

	public final Predicate<Field> isNullableField = (field) -> {
		if (!field.isAnnotationPresent(Column.class)) {
            return true;
        }
		return field.getAnnotation(Column.class).nullable();
	};

	public final Predicate<Field> isNotNullableField = (field) ->
		!isNullableField.test(field);

	public <E extends MkEntity> List<Field> findIdFields(final E entity) {
		final Field[] fields = entity.getClass().getDeclaredFields();
		return Stream.of(fields).filter(isIdField).toList();
	}

	public <E extends MkEntity> List<Field> findUniqueFields(final E entity) {
		final Field[] fields = entity.getClass().getDeclaredFields();
		return Stream.of(fields).filter(isUniqueField).toList();
	}

	public <E extends MkEntity> List<Field> findNullableFields(final E entity) {
		final Field[] fields = entity.getClass().getDeclaredFields();
		return Stream.of(fields).filter(isNullableField).toList();
	}

	public <E extends MkEntity> List<Field> findNotNullableFields(final E entity) {
		final Field[] fields = entity.getClass().getDeclaredFields();
		return Stream.of(fields).filter(isNotNullableField).toList();
	}

	private <E extends MkEntity> Example<E> buildFilter(final List<Field> includeFields, final E entity) {

		final String[] excludeFields = Stream.of(entity.getClass().getDeclaredFields())
				.filter(field -> !includeFields.contains(field))
				.map(Field::getName)
				.toArray(String[]::new);

		final ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths(excludeFields);
		return Example.of(entity, matcher);
	}

	public <E extends MkEntity> Example<E> buildStrictFilter(final E entity) {
		return Example.of(entity);
	}

	public <E extends MkEntity> Example<E> buildIdFilter(final E entity) {

		final List<Field> idFiedls = findIdFields(entity);
		final List<Field> nullIdFields = MkReflectionUtils
				.getNullFields(entity, idFiedls);

		if (nullIdFields.size() != 0) {
            throw new RuntimeException();
        }

		return buildFilter(idFiedls, entity);
	}

	public <E extends MkEntity> Example<E> buildUniqueFilter(final E entity) {

		final List<Field> uniqueFields = findUniqueFields(entity);
		final List<Field> nonNullUniqueFields = MkReflectionUtils
				.getNonNullFields(entity, uniqueFields);

		if (nonNullUniqueFields.isEmpty()) {
            throw new RuntimeException();
        }

		return buildFilter(nonNullUniqueFields, entity);
	}


	public <E extends MkEntity> Example<E> buildFlexibleFilter(final E entity) {

		try {
			return buildIdFilter(entity);
		} catch (final RuntimeException e) {}

		try {
			return buildUniqueFilter(entity);
		} catch (final RuntimeException e) {}

		return buildStrictFilter(entity);
	}

	public <E extends MkEntity> Example<E> buildFilter(final E entity, MkFilterType filterType) {

		return switch (filterType) {
			case ID -> buildIdFilter(entity);
			case UNIQUE -> buildUniqueFilter(entity);
			case FLEXIBLE -> buildFlexibleFilter(entity);
			case STRICT -> buildStrictFilter(entity);
		};
	}

}
