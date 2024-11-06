package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save;

import java.util.List;
import org.mk96.extensible.api.crud.domain.model.save.safe.update.MkUpdateSave;
import org.mk96.extensible.api.crud.domain.port.save.update.MkUpdatePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaUpdateAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkUpdatePort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM update(MkUpdateSave<DOM> update) {
		
		EN exEntity = mapper.map(update.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildIdFilter(exEntity);
		
		if(!repository.exists(exFilter))
			throw new MkCrudException("[update] entity do not exists");

		// TODO meter el IdVerify
		
		EN enToUpdate = mapper.map(update.getUpdate());
		EN enUpdated = repository.save(enToUpdate);
		
		return mapper.map(enUpdated);
	}

	@Override
	@Transactional
	public List<DOM> updateAll(List<MkUpdateSave<DOM>> updates) {
		return updates.stream().map(this::update).toList();
	}

}
