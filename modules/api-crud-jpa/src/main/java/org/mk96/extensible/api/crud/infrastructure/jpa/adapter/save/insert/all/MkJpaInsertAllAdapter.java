package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.insert.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
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
public class MkJpaInsertAllAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkInsertAllPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> insertAll(List<MkInsertSave<DOM>> domInserts) {

	    List<MkFilter<EN>> enFilters = domInserts.stream()
	        .map(MkInsertSave::getFilter)
	        .map(MkFilter.transform(mapper::map))
	        .toList();

	    Specification<EN> enSpecs = MkJpaFilterUtils.buildSpec(enFilters);

		if(repository.exists(enSpecs)) {
            throw new MkCrudException("[insert] entity alrady exists");
        }

		List<EN> ensToInsert = domInserts.stream()
		    .map(MkInsertSave::getSave)
		    .map(mapper::map)
		    .toList();

		List<EN> ensInserted = repository.saveAll(ensToInsert);
		return ensInserted.stream().map(mapper::map).toList();
	}

}
