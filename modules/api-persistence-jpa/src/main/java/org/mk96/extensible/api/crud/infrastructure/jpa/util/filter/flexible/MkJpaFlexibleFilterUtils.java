package org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.flexible;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.id.MkJpaIdFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.strict.MkJpaStrictFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.unique.MkJpaUniqueFilterUtils;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.exception.MkFilterCastException;
import org.mk96.extensible.api.crud.type.filter.exception.MkFilterNullException;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import org.mk96.extensible.api.crud.type.filter.simple.flexible.MkFlexibleFilter;
import org.springframework.data.jpa.domain.Specification;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaFlexibleFilterUtils {
	
    public <EN extends MkEntity> Specification<EN> buildSpec(final MkFlexibleFilter<EN> flexibleFilter) {
        final List<Field> filterFields = findFilterFields(flexibleFilter);
        return MkJpaUtils.buildSpec(flexibleFilter.getFilter(), filterFields);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<MkFlexibleFilter<EN>> flexibleFilters) {
        Map<EN, List<Field>> includeFieldsByEntity = flexibleFilters.stream()
                .collect(Collectors.toMap(
                        MkFlexibleFilter::getFilter,
                        MkJpaStrictFilterUtils::findFilterFields)
                );

        return MkJpaUtils.buildSpec(includeFieldsByEntity);
    }

    public <EN extends MkEntity> MkFlexibleFilter<EN> cast(final MkFilter<EN> filter) {
        if(filter instanceof MkFlexibleFilter) {
            return (MkFlexibleFilter<EN>) filter;
        } else {
            throw new MkFilterCastException(filter, MkFlexibleFilter.class);
        }
    }

    public <EN extends MkEntity> List<Field> findFilterFields(final MkSimpleFilter<EN> simpleFilter) {

        try {
			return MkJpaIdFilterUtils.findFilterFields(simpleFilter);
		} catch (MkFilterNullException e) {}
        
        try {
			return MkJpaUniqueFilterUtils.findFilterFields(simpleFilter);
		} catch (MkFilterNullException e) {}
        
        return MkJpaStrictFilterUtils.findFilterFields(simpleFilter);
    }

}
