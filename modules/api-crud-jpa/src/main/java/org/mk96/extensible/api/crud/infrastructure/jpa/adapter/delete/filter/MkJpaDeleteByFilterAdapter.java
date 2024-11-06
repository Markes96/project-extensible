package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter;

import org.mk96.extensible.api.crud.domain.port.delete.filter.MkDeleteByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.all.MkDeleteAllByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.many.MkDeleteManyByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.one.MkDeleteOneByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.all.MkJpaDeleteAllByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.many.MkJpaDeleteManyByFilterAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.one.MkJpaDeleteOneByFilterAdapter;
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
public class MkJpaDeleteByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkDeleteByFilterPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaDeleteByFilterAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_delete_filter_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkDeleteOneByFilterPort<DOM> deleteOneByFilter;

	@Delegate
	private MkDeleteManyByFilterPort<DOM> deleteManyByFilter;

	@Delegate
	private MkDeleteAllByFilterPort<DOM> deleteAllByFilter;

	@PostConstruct
	void init_delete_filter_adapter() {
		deleteOneByFilter = new MkJpaDeleteOneByFilterAdapter<>(repository, mapper);
		deleteManyByFilter = new MkJpaDeleteManyByFilterAdapter<>(repository, mapper);
		deleteAllByFilter = new MkJpaDeleteAllByFilterAdapter<>(repository, mapper);
	}

}
