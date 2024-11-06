package org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.id;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.exception.MkFilterCastException;
import org.mk96.extensible.api.crud.type.filter.exception.MkFilterNullException;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.util.MkCrudUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaIdFilterUtils {

    public <EN extends MkEntity> Specification<EN> buildSpec(final MkIdFilter<EN> idFilter) {
        final List<Field> filterFields = findFilterFields(idFilter);
        return MkJpaUtils.buildSpec(idFilter.getFilter(), filterFields);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<MkIdFilter<EN>> idFilters) {
        Map<EN, List<Field>> includeFieldsByEntity = idFilters.stream()
                .collect(Collectors.toMap(
                        MkIdFilter::getFilter,
                        MkJpaIdFilterUtils::findFilterFields)
                );

        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    public <EN extends MkEntity> MkIdFilter<EN> cast(final MkFilter<EN> filter) {
        if(filter instanceof MkIdFilter) {
            return (MkIdFilter<EN>) filter;
        } else {
            throw new MkFilterCastException(filter, MkIdFilter.class);
        }
    }

    public <EN extends MkEntity> List<Field> findFilterFields(final MkSimpleFilter<EN> simpleFilter) {

        final List<Field> idFiedls = MkCrudUtils.findIdFields(simpleFilter.getFilter());
        final List<Field> nullIdFields = MkReflectionUtils.getNullFields(simpleFilter.getFilter(), idFiedls);

        if (!CollectionUtils.isEmpty(nullIdFields)) {
            throw new MkFilterNullException(simpleFilter, nullIdFields);
        }

        return idFiedls;
    }

}
