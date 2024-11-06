package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert;

import org.mk96.extensible.api.crud.domain.port.save.insert.MkInsertPort;
import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.domain.port.save.insert.one.MkInsertOnePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.all.MkJpaInsertAllAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.one.MkJpaInsertOneAdapter;
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
public class MkJpaInsertAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkInsertPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaInsertAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_insert_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkInsertOnePort<DOM> insertOne;

    @Delegate
    private MkInsertAllPort<DOM> insertAll;

	@PostConstruct
	void init_insert_adapter() {
	    insertOne = new MkJpaInsertOneAdapter<>(repository, mapper);
	    insertAll = new MkJpaInsertAllAdapter<>(repository, mapper);
	}

}
