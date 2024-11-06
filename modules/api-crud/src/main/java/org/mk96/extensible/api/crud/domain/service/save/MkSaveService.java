package org.mk96.extensible.api.crud.domain.service.save;

import org.mk96.extensible.api.crud.domain.service.save.insert.MkInsertService;
import org.mk96.extensible.api.crud.domain.service.save.merge.MkMergeService;
import org.mk96.extensible.api.crud.domain.service.save.update.MkUpdateService;
import org.mk96.extensible.api.crud.domain.service.save.upsert.MkUpsertService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveService<DOM extends MkDomain>
	extends MkInsertService<DOM>,
	MkMergeService<DOM>,
	MkUpdateService<DOM>,
	MkUpsertService<DOM> {}
