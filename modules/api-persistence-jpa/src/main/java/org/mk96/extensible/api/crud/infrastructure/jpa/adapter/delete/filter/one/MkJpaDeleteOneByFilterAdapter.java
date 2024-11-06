package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.delete.filter.one;

import static org.assertj.core.api.Assertions.filter;
import org.mk96.extensible.api.crud.domain.port.delete.filter.one.MkDeleteOneByFilterPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaDeleteOneByFilterAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
	implements MkDeleteOneByFilterPort<DOM> {

	@Autowired
	private MkJpaRepository<EN, ID> repository;

	@Autowired
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM deleteOne(MkFilter<DOM> domFilter) {

	    MkFilter<EN> enFilter = domFilter.map(mapper::map);
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, filter.getFilterType());
		EN entity = repository.findOne(exFilter)
				.orElseThrow(MkJpaUtils.error("[deleteByFilter] entity do not exists"));

		repository.delete(entity);
		return mapper.map(entity);
	}

}
