package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.find.id.all.MkFindAllByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindAllByIdAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkFindAllByIdPort<DOM, ID> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> findAllById(List<ID> ids) {
		return repository.findAllById(ids)
				.stream().map(mapper::map).toList();
	}



}
