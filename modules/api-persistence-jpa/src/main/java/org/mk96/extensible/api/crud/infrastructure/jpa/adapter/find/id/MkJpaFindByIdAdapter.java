package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id;

import org.mk96.extensible.api.crud.domain.port.find.id.MkFindByIdPort;
import org.mk96.extensible.api.crud.domain.port.find.id.all.MkFindAllByIdPort;
import org.mk96.extensible.api.crud.domain.port.find.id.one.MkFindOneByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id.all.MkJpaFindAllByIdAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id.one.MkJpaFindOneByIdAdapter;
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
public class MkJpaFindByIdAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindByIdPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	public MkJpaFindByIdAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.init_find_id_adapter();
	}
	
	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////
	
	@Delegate
	private MkFindOneByIdPort<DOM, ID> findOneById;
	
	@Delegate
	private MkFindAllByIdPort<DOM, ID> findAllById;
	
	@PostConstruct
	void init_find_id_adapter() {
		findOneById = new MkJpaFindOneByIdAdapter<>(repository, mapper);
		findAllById = new MkJpaFindAllByIdAdapter<>(repository, mapper);
	}

}
