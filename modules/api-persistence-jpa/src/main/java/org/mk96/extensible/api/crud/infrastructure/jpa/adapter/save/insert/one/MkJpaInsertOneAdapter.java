package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.one;

import org.mk96.extensible.api.crud.domain.model.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.crud.domain.port.save.insert.one.MkInsertOnePort;
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
public class MkJpaInsertOneAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkInsertOnePort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM insertOne(MkInsertSave<DOM> insert) {
		
		EN exEntity = mapper.map(insert.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, insert.getFilterType());
		
		if(repository.exists(exFilter))
			throw new MkCrudException("[insert] entity alrady exists");
		
		EN enToInsert = mapper.map(insert.getUpdate());
		EN enInserted = repository.save(enToInsert);
		
		return mapper.map(enInserted);
	}

}
