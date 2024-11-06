package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.save.update.all.MkUpdateAllPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.save.safe.update.MkUpdateSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaUpdateAllAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkUpdateAllPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> updateAll(List<MkUpdateSave<DOM>> updates) {

	    List<MkFilter<EN>> enFilters = updates.stream()
	        .map(MkUpdateSave::getFilter)
	        .map(MkFilter.transform(mapper::map))
	        .toList();

	    Specification<EN> enSpecs = MkJpaFilterUtils.buildSpec(enFilters);

		if(repository.count(enSpecs) >= updates.size()) {
            throw new MkCrudException("[update] entity do not exists");
        }

		List<EN> ensToUpdate = updates.stream()
		    .map(MkUpdateSave::getSave)
		    .map(mapper::map)
		    .toList();

		List<EN> ensUpdated = repository.saveAll(ensToUpdate);
		return ensUpdated.stream().map(mapper::map).toList();
	}

}
