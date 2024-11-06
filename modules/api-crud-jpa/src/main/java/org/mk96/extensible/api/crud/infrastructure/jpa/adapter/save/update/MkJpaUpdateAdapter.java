package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update;

import org.mk96.extensible.api.crud.domain.port.save.update.MkUpdatePort;
import org.mk96.extensible.api.crud.domain.port.save.update.all.MkUpdateAllPort;
import org.mk96.extensible.api.crud.domain.port.save.update.one.MkUpdateOnePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update.all.MkJpaUpdateAllAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update.one.MkJpaUpdateOneAdapter;
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
public class MkJpaUpdateAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkUpdatePort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaUpdateAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_update_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkUpdateOnePort<DOM> updateOne;

    @Delegate
    private MkUpdateAllPort<DOM> updateAll;

	@PostConstruct
	void init_update_adapter() {
	    updateOne = new MkJpaUpdateOneAdapter<>(repository, mapper);
	    updateAll = new MkJpaUpdateAllAdapter<>(repository, mapper);
	}

}
