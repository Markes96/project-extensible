package org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.id;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.dto.exception.MkNullIdFilterException;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.util.MkCrudUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaIdFilterUtils {

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<MkFilter<EN>> filters) {

        List<EN> idFilters = filters.stream()
                .map(MkJpaIdFilterUtils::cast)
                .map(MkIdFilter::getFilter)
                .toList();

        return buildIdSpec(idFilters);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final MkFilter<EN> filter) {
        return buildIdSpec(cast(filter).getFilter());
    }

    private <EN extends MkEntity> MkIdFilter<EN> cast(final MkFilter<EN> filter) {
        if(filter instanceof MkIdFilter) {
            return (MkIdFilter<EN>) filter;
        } else {
            throw new RuntimeException();
        }
    }

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

}
