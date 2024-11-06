package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save;

import java.util.List;
import org.mk96.extensible.api.crud.domain.model.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.crud.domain.port.save.upsert.MkUpsertPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaUpsertAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkUpsertPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	public DOM upsert(MkUpsertSave<DOM> upsert) {
		EN enToUpdate = mapper.map(upsert.getUpdate());
		EN enUpdated = repository.save(enToUpdate);
		return mapper.map(enUpdated);
	}

	@Override
	public List<DOM> upsertAll(List<MkUpsertSave<DOM>> upserts) {
		return upserts.stream().map(this::upsert).toList();
	}
	
}
