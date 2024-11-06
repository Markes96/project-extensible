package org.mk96.extensible.api.crud.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkCrudUtils {

    ////////////////////////////////////////////////////////////////////////////
    /// Filter checkers
    ////////////////////////////////////////////////////////////////////////////

    public boolean isIdField(Field field) {
        return field.isAnnotationPresent(Id.class);
    }

    public boolean isUniqueField(Field field) {
        if (!field.isAnnotationPresent(Column.class)) {
            return false;
        }
        return field.getAnnotation(Column.class).unique();
    }

    public boolean isNullableField(Field field) {
        if (!field.isAnnotationPresent(Column.class)) {
            return false;
        }
        return field.getAnnotation(Column.class).unique();
    }

    public boolean isNotNullableField(Field field) {
        return !isNullableField(field);
    }

    ////////////////////////////////////////////////////////////////////////////
    /// Fields finders
    ////////////////////////////////////////////////////////////////////////////

    public <E extends MkEntity> List<Field> findIdFields(final E entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isIdField).toList();
    }

    public <E extends MkEntity> List<Field> findUniqueFields(final E entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isUniqueField).toList();
    }

    public <E extends MkEntity> List<Field> findNullableFields(final E entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isNullableField).toList();
    }

    public <E extends MkEntity> List<Field> findNotNullableFields(final E entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isNotNullableField).toList();
    }

}
