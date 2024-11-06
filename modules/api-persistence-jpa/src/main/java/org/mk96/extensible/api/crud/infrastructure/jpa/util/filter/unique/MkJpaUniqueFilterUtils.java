package org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.unique;

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
import org.mk96.extensible.api.crud.type.filter.simple.unique.MkUniqueFilter;
import org.mk96.extensible.api.crud.util.MkCrudUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaUniqueFilterUtils {

    public <EN extends MkEntity> Specification<EN> buildSpec(final MkUniqueFilter<EN> uniqueFilter) {
        final List<Field> filterFields = findFilterFields(uniqueFilter);
        return MkJpaUtils.buildSpec(uniqueFilter.getFilter(), filterFields);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<MkUniqueFilter<EN>> uniqueFilters) {
        Map<EN, List<Field>> includeFieldsByEntity = uniqueFilters.stream()
                .collect(Collectors.toMap(
                        MkUniqueFilter::getFilter,
                        MkJpaUniqueFilterUtils::findFilterFields)
                );

        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    public <EN extends MkEntity> MkUniqueFilter<EN> cast(final MkFilter<EN> filter) {
        if(filter instanceof MkUniqueFilter) {
            return (MkUniqueFilter<EN>) filter;
        } else {
            throw new MkFilterCastException(filter, MkUniqueFilter.class);
        }
    }

    public <EN extends MkEntity> List<Field> findFilterFields(final MkSimpleFilter<EN> simpleFilter) {

        final List<Field> uniqueFields = MkCrudUtils.findUniqueFields(simpleFilter.getFilter());
        final List<Field> nonNullUniqueFields = MkReflectionUtils.getNullFields(simpleFilter.getFilter(), uniqueFields);

        if (CollectionUtils.isEmpty(nonNullUniqueFields)) {
            throw new MkFilterNullException(simpleFilter, MkReflectionUtils.getNullFields(simpleFilter.getFilter(), uniqueFields));
        }
        return nonNullUniqueFields;
    }

}
