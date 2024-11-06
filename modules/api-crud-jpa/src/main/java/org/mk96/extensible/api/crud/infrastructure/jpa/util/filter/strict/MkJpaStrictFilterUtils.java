package org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.strict;

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
import org.mk96.extensible.api.crud.type.filter.simple.strict.MkStrictFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaStrictFilterUtils {

    public <EN extends MkEntity> Specification<EN> buildSpec(final MkStrictFilter<EN> strictFilter) {
        final List<Field> filterFields = findFilterFields(strictFilter);
        return MkJpaUtils.buildSpec(strictFilter.getFilter(), filterFields);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<MkStrictFilter<EN>> strictFilters) {
        Map<EN, List<Field>> includeFieldsByEntity = strictFilters.stream()
                .collect(Collectors.toMap(
                        MkStrictFilter::getFilter,
                        MkJpaStrictFilterUtils::findFilterFields)
                );

        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    public <EN extends MkEntity> MkStrictFilter<EN> cast(final MkFilter<EN> filter) {
        if(filter instanceof MkStrictFilter) {
            return (MkStrictFilter<EN>) filter;
        } else {
            throw new MkFilterCastException(filter, MkStrictFilter.class);
        }
    }

    public <EN extends MkEntity> List<Field> findFilterFields(final MkSimpleFilter<EN> simpleFilter) {

        final List<Field> nonNullFields = MkReflectionUtils.getNonNullFields(simpleFilter.getFilter());

        if (CollectionUtils.isEmpty(nonNullFields)) {
            throw new MkFilterNullException(simpleFilter, MkReflectionUtils.getNullFields(simpleFilter.getFilter()));
        }
        return nonNullFields;
    }

}
