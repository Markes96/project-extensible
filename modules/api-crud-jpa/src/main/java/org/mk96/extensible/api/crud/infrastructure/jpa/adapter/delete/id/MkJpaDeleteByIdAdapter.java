package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.id;

import org.mk96.extensible.api.crud.domain.port.delete.id.MkDeleteByIdPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.all.MkDeleteAllByIdPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.one.MkDeleteOneByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.id.all.MkJpaDeleteAllByIdAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.id.one.MkJpaDeleteOneByIdAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaDeleteByIdAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkDeleteByIdPort<DOM, ID> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	public MkJpaDeleteByIdAdapter(MkJpaRepository<EN, ID> repository) {
		this.repository = repository;
		this.init_delete_id_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkDeleteOneByIdPort<DOM, ID> deleteOneById;

	@Delegate
	private MkDeleteAllByIdPort<DOM, ID> deleteAllById;

	@PostConstruct
	void init_delete_id_adapter() {
		deleteOneById = new MkJpaDeleteOneByIdAdapter<>(repository);
		deleteAllById = new MkJpaDeleteAllByIdAdapter<>(repository);
	}

}
