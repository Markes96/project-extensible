package org.mk96.extensible.api.crud.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;
import org.mk96.extensible.api.crud.infrastructure.dto.MkData;
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

    public <D extends MkData> List<Field> findIdFields(final D entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isIdField).toList();
    }

    public <D extends MkData> List<Field> findUniqueFields(final D entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isUniqueField).toList();
    }

    public <D extends MkData> List<Field> findNullableFields(final D entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isNullableField).toList();
    }

    public <D extends MkData> List<Field> findNotNullableFields(final D entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        return Stream.of(fields).filter(MkCrudUtils::isNotNullableField).toList();
    }

}
