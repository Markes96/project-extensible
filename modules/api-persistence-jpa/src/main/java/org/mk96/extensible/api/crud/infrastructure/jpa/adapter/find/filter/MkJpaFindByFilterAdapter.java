package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter;

import org.mk96.extensible.api.crud.domain.port.find.filter.MkFindByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.all.MkFindAllByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.many.MkFindManyByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.one.MkFindOneByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.all.MkJpaFindAllByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.many.MkJpaFindManyByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.one.MkJpaFindOneByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindByFilterPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaFindByFilterAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.init_find_filter_adapter();
	}
	
	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////
	
	@Delegate
	private MkFindOneByFilterPort<DOM> findOneByFilter;
	
	@Delegate
	private MkFindManyByFilterPort<DOM> findManyByFilter;
	
	@Delegate
	private MkFindAllByFilterPort<DOM> findAllByFilter;
	
	@PostConstruct
	void init_find_filter_adapter() {
		findOneByFilter = new MkJpaFindOneByFilterAdapter<>(repository, mapper);
		findManyByFilter = new MkJpaFindManyByFilterAdapter<>(repository, mapper);
		findAllByFilter = new MkJpaFindAllByFilterAdapter<>(repository, mapper);
	}

}
