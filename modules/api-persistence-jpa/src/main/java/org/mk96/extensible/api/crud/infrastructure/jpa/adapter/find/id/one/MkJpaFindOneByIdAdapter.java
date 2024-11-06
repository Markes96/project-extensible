package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.find.id.one;

import static org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils.error;

import org.mk96.extensible.api.crud.domain.port.find.id.one.MkFindOneByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaFindOneByIdAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkFindOneByIdPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM findOneById(ID id) {
		EN entity = repository.findById(id)
				.orElseThrow(error("[findById] entity do not exists"));
		return mapper.map(entity);
	}

}
