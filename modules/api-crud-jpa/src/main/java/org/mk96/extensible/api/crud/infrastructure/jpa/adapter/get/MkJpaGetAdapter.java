package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.get;

import org.mk96.extensible.api.crud.domain.port.get.MkGetPort;
import org.mk96.extensible.api.crud.domain.port.get.all.MkGetAllPort;
import org.mk96.extensible.api.crud.domain.port.get.page.MkGetPagePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.get.all.MkJpaGetAllAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.get.page.MkJpaGetPageAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkJpaGetAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
	implements MkGetPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaGetAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_get_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkGetAllPort<DOM> getAll;

	@Delegate
	private MkGetPagePort<DOM> getPage;

	@PostConstruct
	void init_get_adapter() {
		getAll = new MkJpaGetAllAdapter<>(repository, mapper);
		getPage = new MkJpaGetPageAdapter<>(repository, mapper);
	}

}
