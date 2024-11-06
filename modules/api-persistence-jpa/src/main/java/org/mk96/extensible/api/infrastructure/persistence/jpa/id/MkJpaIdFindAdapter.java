package org.mk96.extensible.api.infrastructure.persistence.jpa.id;

import java.util.Optional;

import org.mk96.extensible.api.crud.domain.port.id.MkIdFindPort;
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
public class MkJpaIdFindAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkIdFindPort<DOM, ID> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkPersistenceMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM find(ID id) {
		
		Optional<EN> entity = repository.findById(id);
		
		if(entity.isEmpty()) 
			throw new MkJpaExcetion("[error][find] entity do not exists");
		
		return mapper.map(entity.get());
	}

}
