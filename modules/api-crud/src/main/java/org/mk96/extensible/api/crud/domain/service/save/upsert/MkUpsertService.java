package org.mk96.extensible.api.crud.domain.service.save.upsert;

import org.mk96.extensible.api.crud.domain.service.save.upsert.all.MkUpsertAllService;
import org.mk96.extensible.api.crud.domain.service.save.upsert.one.MkUpsertOneService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkUpsertService<DOM extends MkDomain>
	extends MkUpsertOneService<DOM>,
	MkUpsertAllService<DOM> {}
