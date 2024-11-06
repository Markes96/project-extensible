package org.mk96.extensible.api.crud.infrastructure.jpa.util;

import java.util.List;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.flexible.MkJpaFlexibleFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.id.MkJpaIdFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.strict.MkJpaStrictFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.filter.unique.MkJpaUniqueFilterUtils;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.springframework.data.jpa.domain.Specification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaFilterUtils {

	public <EN extends MkEntity> Specification<EN> buildSpec(MkFilter<EN> filter) {
        return switch (filter.getFilterType()) {
            case ID -> buildIdSpec(filter);
            case UNIQUE -> buildUniqueSpec(filter);
            case FLEXIBLE -> buildFlexibleSpec(filter);
            case STRICT -> buildStrictSpec(filter);
        };
    }
	
    public <EN extends MkEntity> Specification<EN> buildSpec(List<MkFilter<EN>> filters) {
        List<Specification<EN>> specs = filters.stream()
                .map(MkJpaFilterUtils::buildSpec)
                .toList();

        return Specification.anyOf(specs);
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

}
