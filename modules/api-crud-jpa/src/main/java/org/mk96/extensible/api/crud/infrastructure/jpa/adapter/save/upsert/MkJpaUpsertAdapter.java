package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.upsert;

import org.mk96.extensible.api.crud.domain.port.save.upsert.MkUpsertPort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.all.MkUpsertAllPort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.one.MkUpsertOnePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.upsert.all.MkJpaUpsertAllAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.upsert.one.MkJpaUpsertOneAdapter;
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
public class MkJpaUpsertAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkUpsertPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaUpsertAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_upsert_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkUpsertOnePort<DOM> upsertOne;

    @Delegate
    private MkUpsertAllPort<DOM> upsertAll;

	@PostConstruct
	void init_upsert_adapter() {
	    upsertOne = new MkJpaUpsertOneAdapter<>(repository, mapper);
	    upsertAll = new MkJpaUpsertAllAdapter<>(repository, mapper);
	}

}
