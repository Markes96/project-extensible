package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.one;

import org.mk96.extensible.api.crud.domain.model.filter.MkFilter;
import org.mk96.extensible.api.crud.domain.port.find.filter.one.MkFindOneByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindOneByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindOneByFilterPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	public DOM findOne(MkFilter<DOM> filter) {
		EN exEntity = mapper.map(filter.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, filter.getFilterType());
		EN entity = repository.findOne(exFilter)
				.orElseThrow(MkJpaUtils.error("[deleteByFilter] entity do not exists"));

		return mapper.map(entity);
	}

}
