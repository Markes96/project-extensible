package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete;

import org.mk96.extensible.api.crud.domain.port.delete.MkDeletePort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.MkDeleteByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.MkDeleteByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.MkJpaDeleteByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.id.MkJpaDeleteByIdAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaDeleteAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkDeletePort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	public MkJpaDeleteAdapter(
			MkJpaRepository<EN, ID> repository, 
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_delete_adapter();
	}
	
	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////
	
	@Delegate
	private MkDeleteByIdPort<DOM, ID> deleteById;
	
	@Delegate
	private MkDeleteByFilterPort<DOM> deleteByFilter;
	
	@PostConstruct
	void init_delete_adapter() {
		deleteById = new MkJpaDeleteByIdAdapter<>(repository);
		deleteByFilter = new MkJpaDeleteByFilterAdapter<>(repository, mapper);
	}

}
