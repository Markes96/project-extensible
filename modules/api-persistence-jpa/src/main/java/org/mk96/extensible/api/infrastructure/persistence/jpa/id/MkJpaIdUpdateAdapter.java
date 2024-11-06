package org.mk96.extensible.api.infrastructure.persistence.jpa.id;

import org.mk96.extensible.api.crud.domain.port.id.MkIdUpdatePort;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.persistence.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.infrastructure.persistence.jpa.type.MkJpaExcetion;
import org.mk96.extensible.api.infrastructure.persistence.mapper.MkPersistenceMapper;
import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MkJpaIdUpdateAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkIdUpdatePort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkPersistenceMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM update(ID id, DOM dom) {
		
		if(!repository.existsById(id)) 
			throw new MkJpaExcetion("[error][update] entity do not exists");
		
		EN entity = mapper.map(dom);
		entity = repository.save(entity);
		return mapper.map(entity);
	}

}
