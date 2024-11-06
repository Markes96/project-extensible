package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save;

import org.mk96.extensible.api.crud.domain.port.save.MkSavePort;
import org.mk96.extensible.api.crud.domain.port.save.insert.MkInsertPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.MkMergePort;
import org.mk96.extensible.api.crud.domain.port.save.update.MkUpdatePort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.MkUpsertPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.MkJpaInsertAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge.MkJpaMergeAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update.MkJpaUpdateAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.upsert.MkJpaUpsertAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaSaveAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
	implements MkSavePort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaSaveAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_save_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkInsertPort<DOM> insert;

	@Delegate
	private MkUpdatePort<DOM> update;

	@Delegate
	private MkUpsertPort<DOM> upsert;

	@Delegate
	private MkMergePort<DOM> mergeUpdate;

	@PostConstruct
	void init_save_adapter() {
		insert = new MkJpaInsertAdapter<>(repository, mapper);
		update = new MkJpaUpdateAdapter<>(repository, mapper);
		upsert = new MkJpaUpsertAdapter<>(repository, mapper);
		mergeUpdate = new MkJpaMergeAdapter<>(repository, mapper);
	}

}
