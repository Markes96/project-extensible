package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.update.one;

import org.mk96.extensible.api.crud.domain.port.save.update.one.MkUpdateOnePort;
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
public class MkJpaUpdateOneAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkUpdateOnePort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public DOM updateOne(MkUpdateSave<DOM> update) {

	    MkFilter<EN> enFilter = update.getFilter().map(mapper::map);
	    Specification<EN> enSpec = MkJpaFilterUtils.buildSpec(enFilter);

		if(!repository.exists(enSpec)) {
            throw new MkCrudException("[update] entity do not exists");
        }

		EN enToUpdate = mapper.map(update.getSave());
		EN enUpdated = repository.save(enToUpdate);
		return mapper.map(enUpdated);
	}

}
