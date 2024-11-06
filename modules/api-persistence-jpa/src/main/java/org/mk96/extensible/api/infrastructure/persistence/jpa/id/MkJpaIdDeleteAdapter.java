package org.mk96.extensible.api.infrastructure.persistence.jpa.id;

import org.mk96.extensible.api.crud.domain.port.id.MkIdDeletePort;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.persistence.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.infrastructure.persistence.jpa.type.MkJpaExcetion;
import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MkJpaIdDeleteAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkIdDeletePort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;

	@Override
	@Transactional
	public void delete(ID id) {
		
		if(!repository.existsById(id)) 
			throw new MkJpaExcetion("[error][delete] entity do not exists");
		
		repository.deleteById(id);
	}

}
