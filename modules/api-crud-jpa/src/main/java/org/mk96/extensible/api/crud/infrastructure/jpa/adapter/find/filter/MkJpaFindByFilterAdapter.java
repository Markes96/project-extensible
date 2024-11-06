package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter;

import org.mk96.extensible.api.crud.domain.port.find.filter.MkFindByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.all.MkFindAllByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.many.MkFindManyByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.one.MkFindOneByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.page.MkFindPageByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.all.MkJpaFindAllByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.many.MkJpaFindManyByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.one.MkJpaFindOneByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.filter.page.MkJpaFindPageByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkFindByFilterPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaFindByFilterAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_find_filter_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkFindOneByFilterPort<DOM> findOneByFilter;

	@Delegate
	private MkFindManyByFilterPort<DOM> findManyByFilter;

	@Delegate
	private MkFindAllByFilterPort<DOM> findAllByFilter;

	@Delegate
	private MkFindPageByFilterPort<DOM> findPageByFilter;

	@PostConstruct
	void init_find_filter_adapter() {
		findOneByFilter = new MkJpaFindOneByFilterAdapter<>(repository, mapper);
		findManyByFilter = new MkJpaFindManyByFilterAdapter<>(repository, mapper);
		findAllByFilter = new MkJpaFindAllByFilterAdapter<>(repository, mapper);
		findPageByFilter = new MkJpaFindPageByFilterAdapter<>(repository, mapper);
	}

}
