package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.all;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.mk96.extensible.api.crud.domain.model.filter.MkFilter;
import org.mk96.extensible.api.crud.domain.model.save.insert.MkInsert;
import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.infrastructure.type.MkCrudException;
import org.mk96.extensible.api.crud.infrastructure.type.data.MkEntity;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaInsertAllAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkInsertAllPort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> insertAll(List<MkInsert<DOM>> inserts) {
		
		EN exEntity = mapper.map(insert.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, insert.getFilterType());
		
		if(repository.exists(exFilter))
			throw new MkCrudException("[insert] entity alrady exists");
		
		EN enToInsert = mapper.map(insert.getUpdate());
		EN enInserted = repository.save(enToInsert);
		
		return mapper.map(enInserted);
		
		return inserts.stream().map(this::insertOne).toList();
	}
	
	private Stream<EN> findEntities(MkFilter<DOM> filter, List<EN> entities) {
		EN exEntity = mapper.map(filter.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, filter.getFilterType());
		
		repository.find
		
		return repository.findAll(exFilter).stream();
	}

}
