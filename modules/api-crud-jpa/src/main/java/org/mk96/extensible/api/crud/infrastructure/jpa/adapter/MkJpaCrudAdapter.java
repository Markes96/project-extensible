package org.mk96.extensible.api.crud.infrastructure.jpa.adapter;

import org.mk96.extensible.api.crud.domain.port.MkCrudPort;
import org.mk96.extensible.api.crud.domain.port.delete.MkDeletePort;
import org.mk96.extensible.api.crud.domain.port.find.MkFindPort;
import org.mk96.extensible.api.crud.domain.port.get.MkGetPort;
import org.mk96.extensible.api.crud.domain.port.save.MkSavePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.MkJpaDeleteAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.MkJpaFindAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.get.MkJpaGetAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.MkJpaSaveAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaCrudAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkCrudPort<DOM, ID> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaCrudAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_crud_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////
	
	@Delegate
	private MkGetPort<DOM> get;

	@Delegate
	private MkFindPort<DOM, ID> find;

	@Delegate
	private MkSavePort<DOM> save;

	@Delegate
	private MkDeletePort<DOM, ID> delete;

	@PostConstruct
	void init_crud_adapter() {
		get = new MkJpaGetAdapter<>(repository, mapper);
		find = new MkJpaFindAdapter<>(repository, mapper);
		save = new MkJpaSaveAdapter<>(repository, mapper);
		delete = new MkJpaDeleteAdapter<>(repository, mapper);
	}

}
