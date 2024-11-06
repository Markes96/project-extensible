package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.id.one;

import org.mk96.extensible.api.crud.domain.port.delete.id.one.MkDeleteOneByIdPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaDeleteOneByIdAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkDeleteOneByIdPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;

	@Override
	@Transactional
	public void deleteOneById(ID id) {
		repository.deleteById(id);
	}

}
