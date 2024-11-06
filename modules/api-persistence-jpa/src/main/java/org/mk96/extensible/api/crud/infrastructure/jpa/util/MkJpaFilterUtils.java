package org.mk96.extensible.api.crud.infrastructure.jpa.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.dto.exception.MkNullIdFilterException;
import org.mk96.extensible.api.crud.infrastructure.dto.exception.MkNullStrictFilterException;
import org.mk96.extensible.api.crud.infrastructure.dto.exception.MkNullUniqueFilterException;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.simple.flexible.MkFlexibleFilter;
import org.mk96.extensible.api.crud.util.MkCrudUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaFilterUtils {

    ////////////////////////////////////////////////////////////////////////////
    /// Strict Filter
    ////////////////////////////////////////////////////////////////////////////

    public <EN extends MkEntity> Specification<EN> buildStrictSpec(final EN entity) {
        final List<Field> nonNullFields = findNotNullFields(entity);
        return MkJpaUtils.buildSpec(entity, nonNullFields);
    }

    public <EN extends MkEntity> Specification<EN> buildStrictSpec(final List<EN> entities) {
        Map<EN, List<Field>> includeFieldsByEntity =
                entities.stream().collect(Collectors.toMap(e -> e, e -> findNotNullFields(e)));
        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    private <EN extends MkEntity> List<Field> findNotNullFields(final EN entity) {
        final List<Field> nonNullFields = MkReflectionUtils.getNonNullFields(entity);
        if (CollectionUtils.isEmpty(nonNullFields)) {
            throw new MkNullStrictFilterException(MkReflectionUtils.getFields(entity));
        }
        return nonNullFields;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// Id Filter
    ////////////////////////////////////////////////////////////////////////////

    public <EN extends MkEntity> Specification<EN> buildIdSpec(final EN entity) {
        final List<Field> idFiedls = findNotNullIdFields(entity);
        return MkJpaUtils.buildSpec(entity, idFiedls);
    }

    public <EN extends MkEntity> Specification<EN> buildIdSpec(final List<EN> entities) {
        Map<EN, List<Field>> includeFieldsByEntity =
                entities.stream().collect(Collectors.toMap(e -> e, e -> findNotNullIdFields(e)));
        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    private <EN extends MkEntity> List<Field> findNotNullIdFields(final EN entity) {
        final List<Field> idFiedls = MkCrudUtils.findIdFields(entity);
        final List<Field> nullIdFields = MkReflectionUtils.getNullFields(entity, idFiedls);

        if (!CollectionUtils.isEmpty(nullIdFields)) {
            throw new MkNullIdFilterException(idFiedls);
        }

        return idFiedls;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// Unique Filter
    ////////////////////////////////////////////////////////////////////////////

    public <EN extends MkEntity> Specification<EN> buildFlexibleSpec(final MkFilter<EN> filter) {
        if(filter instanceof MkFlexibleFilter) {
            MkFlexibleFilter<EN> flexibleFilter = (MkFlexibleFilter<EN>) filter;
            return buildFlexibleSpec(flexibleFilter.getFilter());
        } else {
            throw new RuntimeException();
        }
    }

    public <EN extends MkEntity> Specification<EN> buildUniqueSpec(final EN entity) {
        final List<Field> uniqueFields = findNotNullUniqueFields(entity);
        return MkJpaUtils.buildSpec(entity, uniqueFields);
    }

    public <EN extends MkEntity> Specification<EN> buildUniqueSpec(final List<EN> entities) {
        Map<EN, List<Field>> includeFieldsByEntity = entities.stream()
                .collect(Collectors.toMap(e -> e, e -> findNotNullUniqueFields(e)));
        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    private <EN extends MkEntity> List<Field> findNotNullUniqueFields(final EN entity) {
        final List<Field> uniqueFields = MkCrudUtils.findUniqueFields(entity);
        final List<Field> nonNullUniqueFields =
                MkReflectionUtils.getNonNullFields(entity, uniqueFields);

        if (nonNullUniqueFields.isEmpty()) {
            throw new MkNullUniqueFilterException(uniqueFields);
        }

        return nonNullUniqueFields;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// Flexible Filter
    ////////////////////////////////////////////////////////////////////////////

    public <EN extends MkEntity> Specification<EN> buildFlexibleSpec(final MkFilter<EN> filter) {
        if(filter instanceof MkFlexibleFilter) {
            MkFlexibleFilter<EN> flexibleFilter = (MkFlexibleFilter<EN>) filter;
            return buildFlexibleSpec(flexibleFilter.getFilter());
        } else {
            throw new RuntimeException();
        }
    }

    public <EN extends MkEntity> Specification<EN> buildFlexibleSpec(final EN entity) {

        try {
            return buildIdSpec(entity);
        } catch (final RuntimeException e) {
        }

        try {
            return buildUniqueSpec(entity);
        } catch (final MkNullUniqueFilterException e) {
        }

        return buildStrictSpec(entity);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(MkFilter<EN> filter) {

        return switch (filter.getFilterType()) {
            case ID -> buildIdSpec(entity);
            case UNIQUE -> buildUniqueSpec(entity);
            case FLEXIBLE -> buildFlexibleSpec(entity);
            case STRICT -> buildStrictSpec(entity);
        };
    }

}
