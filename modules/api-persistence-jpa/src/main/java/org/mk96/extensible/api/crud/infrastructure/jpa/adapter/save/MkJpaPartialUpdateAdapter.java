package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save;

import java.util.List;
import org.mk96.extensible.api.crud.domain.model.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.crud.domain.port.save.merge.MkMergePort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.CollectionUtils;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaPartialUpdateAdapter<DOM extends MkDomain, EN extends MkEntity, ID> 
	implements MkMergePort<DOM> {
	
	@Autowired
	private MkJpaRepository<EN, ID> repository;
	
	@Autowired
	private MkCrudMapper<DOM, EN> mapper;
	
	private final ModelMapper updaterMapper = new ModelMapper();
	
	{
		updaterMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setPropertyCondition(Conditions.isNotNull());
	}

	@Override
	@Transactional
	public DOM partialUpdateOne(MkMergeSave<DOM> update) {
		
		EN exEntity = mapper.map(update.getFilter());
		Example<EN> exFilter = MkJpaUtils.buildFilter(exEntity, update.getFilterType());
		List<EN> enToUpdate = repository.findAll(exFilter);
		
		if(CollectionUtils.isEmpty(enToUpdate))
			throw new MkCrudException("[partialUpdate] entity do not exists");
		
		if(enToUpdate.size() > 1)
			throw new MkCrudException("[partialUpdate] more than 1 entity to update found");
		
		updaterMapper.map(update.getUpdate(), enToUpdate.get(0));

		mapper.update(exEntity);
		EN enUpdated = repository.save(enToUpdate.get(0));
		
		return mapper.map(enUpdated);
	}

	@Override
	@Transactional
	public List<DOM> partialUpdateAll(List<MkMergeSave<DOM>> updates) {
		return updates.stream().map(this::partialUpdateOne).toList();
	}

}
