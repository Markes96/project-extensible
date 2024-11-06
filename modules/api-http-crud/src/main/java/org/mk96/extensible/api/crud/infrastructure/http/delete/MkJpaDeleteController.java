package org.mk96.extensible.api.crud.infrastructure.http.delete;

import org.mk96.extensible.api.crud.domain.port.delete.MkDeletePort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.MkDeleteByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.MkDeleteByIdPort;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.infrastructure.type.data.MkEntity;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public interface MkJpaDeleteController<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkDeletePort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	public MkJpaDeleteController(
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
		deleteById = new MkJpaDeleteByIdController<>(repository);
		deleteByFilter = new MkJpaDeleteByFilteRController<>(repository, mapper);
	}

}
