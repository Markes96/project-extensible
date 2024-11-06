package org.mk96.extensible.api.crud.infrastructure.jpa.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.flexible.MkJpaFlexibleFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.id.MkJpaIdFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.strict.MkJpaStrictFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.unique.MkJpaUniqueFilterUtils;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.springframework.data.jpa.domain.Specification;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaFilterUtils {
	
	///////////////////////////
	/// SINLGE
	///////////////////////////

	public <EN extends MkEntity> Specification<EN> buildSpec(MkFilter<EN> filter) {
		return switch (filter.getFilterType()) {
			case ID -> buildIdSpec(filter);
			case UNIQUE -> buildUniqueSpec(filter);
			case FLEXIBLE -> buildFlexibleSpec(filter);
			case STRICT -> buildStrictSpec(filter);
		};
	}

	public <EN extends MkEntity> Specification<EN> buildIdSpec(MkFilter<EN> filter) {
		return MkJpaIdFilterUtils.buildSpec(MkJpaIdFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> Specification<EN> buildUniqueSpec(MkFilter<EN> filter) {
		return MkJpaUniqueFilterUtils.buildSpec(MkJpaUniqueFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> Specification<EN> buildStrictSpec(MkFilter<EN> filter) {
		return MkJpaStrictFilterUtils.buildSpec(MkJpaStrictFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> Specification<EN> buildFlexibleSpec(MkFilter<EN> filter) {
		return MkJpaFlexibleFilterUtils.buildSpec(MkJpaFlexibleFilterUtils.cast(filter));
	}
	
	///////////////////////////
	/// MULTI
	///////////////////////////
	
	public <EN extends MkEntity> Specification<EN> buildSpec(List<MkFilter<EN>> filters) {
		
		filters.stream()
			.filter(MkSimpleFilter::isCasteable)
			.map(null);
		
        Map<EN, List<Field>> includeFieldsByEntity = filters.stream()
                .collect(Collectors.toMap(
                        MkFilter::getFilter,
                        MkJpaIdFilterUtils::findFilterFields)
                );

        return MkJpaUtils.buildSpec(includeFieldsByEntity);
	}

	public <EN extends MkEntity> List<Field> findFilterFields(MkSimpleFilter<EN> filter) {
		return switch (filter.getFilterType()) {
			case ID -> findIdFilterFields(filter);
			case UNIQUE -> findUniqueFilterFields(filter);
			case FLEXIBLE -> findStrictFilterFields(filter);
			case STRICT -> findFlexibleFilterFields(filter);
		};
	}

	public <EN extends MkEntity> List<Field> findIdFilterFields(MkFilter<EN> filter) {
		return MkJpaIdFilterUtils.findFilterFields(MkJpaIdFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> List<Field> findUniqueFilterFields(MkFilter<EN> filter) {
		return MkJpaUniqueFilterUtils.findFilterFields(MkJpaUniqueFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> List<Field> findStrictFilterFields(MkFilter<EN> filter) {
		return MkJpaStrictFilterUtils.findFilterFields(MkJpaStrictFilterUtils.cast(filter));
	}

	public <EN extends MkEntity> List<Field> findFlexibleFilterFields(MkFilter<EN> filter) {
		return MkJpaFlexibleFilterUtils.findFilterFields(MkJpaFlexibleFilterUtils.cast(filter));
	}

}
