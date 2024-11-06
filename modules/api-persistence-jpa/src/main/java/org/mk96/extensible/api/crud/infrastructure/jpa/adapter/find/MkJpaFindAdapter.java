package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find;

import org.mk96.extensible.api.crud.domain.port.find.MkFindPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.MkFindByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.id.MkFindByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.MkJpaFindByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id.MkJpaFindByIdAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaFindAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	public MkJpaFindAdapter(
			MkJpaRepository<EN, ID> repository, 
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_find_adapter();
	}
	
	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////
	
	@Delegate
	private MkFindByIdPort<DOM, ID> findById;
	
	@Delegate
	private MkFindByFilterPort<DOM> findByFilter;
	
	@PostConstruct
	void init_find_adapter() {
		findById = new MkJpaFindByIdAdapter<>(repository, mapper);
		findByFilter = new MkJpaFindByFilterAdapter<>(repository, mapper);
	}

}
