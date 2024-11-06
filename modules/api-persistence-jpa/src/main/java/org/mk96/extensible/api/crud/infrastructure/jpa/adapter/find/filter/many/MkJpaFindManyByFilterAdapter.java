package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.many;

import java.util.List;
import org.mk96.extensible.api.crud.domain.model.filter.MkFilter;
import org.mk96.extensible.api.crud.domain.port.find.filter.many.MkFindManyByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindManyByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindManyByFilterPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	@Override
	@Transactional
	public List<DOM> findMany(MkFilter<DOM> filter) {
		EN exEntity = mapper.map(filter.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, filter.getFilterType());
		List<EN> entities = repository.findAll(exFilter);
		
		return entities.stream().map(mapper::map).toList();
	}

}
