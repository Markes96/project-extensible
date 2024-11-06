package org.mk96.extensible.api.infrastructure.persistence.jpa.id;

import org.mk96.extensible.api.crud.domain.port.id.MkIdCreatePort;
import org.mk96.extensible.api.crud.domain.port.id.MkIdCrudPort;
import org.mk96.extensible.api.crud.domain.port.id.MkIdDeletePort;
import org.mk96.extensible.api.crud.domain.port.id.MkIdFindPort;
import org.mk96.extensible.api.crud.domain.port.id.MkIdUpdatePort;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.persistence.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.infrastructure.persistence.mapper.MkPersistenceMapper;
import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor
public class MkJpaIdCrudAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkIdCrudPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkPersistenceMapper<DOM, EN> mapper;
	
	public MkJpaIdCrudAdapter(MkJpaRepository<EN, ID> repository, MkPersistenceMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_crud_adapter();
	}

	@Delegate
	private MkIdCreatePort<DOM, ID> createAdapter;
	
	@Delegate
	private MkIdUpdatePort<DOM, ID> updateAdapter;
	
	@Delegate
	private MkIdFindPort<DOM, ID> findAdapter;
	
	@Delegate
	private MkIdDeletePort<DOM, ID> deleteAdapter;

	@PostConstruct
	void init_crud_adapter() {
		this.createAdapter = new MkJpaIdCreateAdapter<>(this.repository, this.mapper);
		this.updateAdapter = new MkJpaIdUpdateAdapter<>(this.repository, this.mapper);
		this.findAdapter = new MkJpaIdFindAdapter<>(this.repository, this.mapper);
		this.deleteAdapter = new MkJpaIdDeleteAdapter<>(this.repository);
	}

}
