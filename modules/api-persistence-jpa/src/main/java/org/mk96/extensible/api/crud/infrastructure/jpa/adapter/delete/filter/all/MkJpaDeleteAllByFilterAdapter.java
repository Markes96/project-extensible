package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.all;

import java.util.List;
import java.util.stream.Stream;
import org.mk96.extensible.api.crud.domain.port.delete.filter.all.MkDeleteAllByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaDeleteAllByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
	implements MkDeleteAllByFilterPort<DOM> {

	@Autowired
	private MkJpaRepository<EN, ID> repository;

	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> deleteAll(List<MkFilter<DOM>> domFilters) {
		
	    List<MkFilter<EN>> enFilters = domFilters.stream()
	    		.map(MkFilter.transform(mapper::map)).toList();
	    
		Specification<EN> enSpec = MkJpaFilterUtils.buildSpec(enFilters);
		List<EN> entities = repository.findAll(enSpec);
		
		List<EN> entities = filters.stream()
				.flatMap(this::findEntities).toList();
		repository.deleteAll(entities);
		return entities.stream().map(mapper::map).toList();
	}

	private Stream<EN> findEntities(MkFilter<DOM> filter) {
		EN exEntity = mapper.map(filter.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, filter.getFilterType());
		return repository.findAll(exFilter).stream();
	}

}
