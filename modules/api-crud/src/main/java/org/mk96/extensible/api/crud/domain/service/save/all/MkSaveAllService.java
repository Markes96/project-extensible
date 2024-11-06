package org.mk96.extensible.api.crud.domain.service.save.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.service.save.insert.all.MkInsertAllService;
import org.mk96.extensible.api.crud.domain.service.save.merge.all.MkMergeAllService;
import org.mk96.extensible.api.crud.domain.service.save.update.all.MkUpdateAllService;
import org.mk96.extensible.api.crud.domain.service.save.upsert.all.MkUpsertAllService;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveAllService<DOM extends MkDomain>
	extends MkInsertAllService<DOM>,
	MkUpdateAllService<DOM>,
	MkUpsertAllService<DOM>,
	MkMergeAllService<DOM> {

	List<DOM> saveAll(List<MkSave<DOM>> saves);

}
