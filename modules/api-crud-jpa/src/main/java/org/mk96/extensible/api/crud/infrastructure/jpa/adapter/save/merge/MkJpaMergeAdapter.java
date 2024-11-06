package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge;

import org.mk96.extensible.api.crud.domain.port.save.merge.MkMergePort;
import org.mk96.extensible.api.crud.domain.port.save.merge.all.MkMergeAllPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.many.MkMergeManyPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.one.MkMergeOnePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge.all.MkJpaMergeAllAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge.many.MkJpaMergeManyAdapter;
import org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge.one.MkJpaMergeOneAdapter;
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
public class MkJpaMergeAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkMergePort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	public MkJpaMergeAdapter(
			MkJpaRepository<EN, ID> repository,
			MkCrudMapper<DOM, EN> mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.init_merge_adapter();
	}

	////////////////////////////////////////////
	// Ports
	////////////////////////////////////////////

	@Delegate
	private MkMergeOnePort<DOM> mergeOne;

    @Delegate
    private MkMergeManyPort<DOM> mergeMany;

    @Delegate
    private MkMergeAllPort<DOM> mergeAll;

	@PostConstruct
	void init_merge_adapter() {
	    mergeOne = new MkJpaMergeOneAdapter<>(repository, mapper);
	    mergeMany = new MkJpaMergeManyAdapter<>(repository, mapper);
	    mergeAll = new MkJpaMergeAllAdapter<>(repository, mapper);
	}

}
