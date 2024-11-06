package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.many;

import java.util.List;

import org.mk96.extensible.api.crud.domain.port.delete.filter.many.MkDeleteManyByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaDeleteManyByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkDeleteManyByFilterPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> deleteMany(MkFilter<DOM> domFilter) {
		
	    MkFilter<EN> enFilter = domFilter.map(mapper::map);
		Specification<EN> enSpec = MkJpaFilterUtils.buildSpec(enFilter);
		List<EN> entities = repository.findAll(enSpec);
		
		repository.deleteAll(entities);
		return entities.stream().map(mapper::map).toList();
	}

}
