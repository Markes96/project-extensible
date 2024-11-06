package org.mk96.extensible.api.crud.domain.service.save.one;

import org.mk96.extensible.api.crud.domain.service.save.insert.one.MkInsertOneService;
import org.mk96.extensible.api.crud.domain.service.save.merge.one.MkMergeOneService;
import org.mk96.extensible.api.crud.domain.service.save.update.one.MkUpdateOneService;
import org.mk96.extensible.api.crud.domain.service.save.upsert.one.MkUpsertOneService;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveOneService<DOM extends MkDomain>
	extends MkInsertOneService<DOM>,
	MkUpdateOneService<DOM>,
	MkUpsertOneService<DOM>,
	MkMergeOneService<DOM> {


	DOM saveOne(MkSave<DOM> save);

}
