package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.upsert.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.save.upsert.all.MkUpsertAllPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaUpsertAllAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
	implements MkUpsertAllPort<DOM> {

	@Autowired(required = false)
	private MkJpaRepository<EN, ID> repository;

	@Autowired(required = false)
	private MkCrudMapper<DOM, EN> mapper;

	@Override
	@Transactional
	public List<DOM> upsertAll(List<MkUpsertSave<DOM>> upserts) {

		List<EN> ensToUpsert = upserts.stream()
		    .map(MkUpsertSave::getSave)
		    .map(mapper::map)
		    .toList();

		List<EN> ensUpserted = repository.saveAll(ensToUpsert);
		return ensUpserted.stream().map(mapper::map).toList();
	}

}
