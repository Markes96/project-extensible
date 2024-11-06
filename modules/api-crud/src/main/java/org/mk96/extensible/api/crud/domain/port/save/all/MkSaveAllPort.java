package org.mk96.extensible.api.crud.domain.port.save.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.all.MkMergeAllPort;
import org.mk96.extensible.api.crud.domain.port.save.update.all.MkUpdateAllPort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.all.MkUpsertAllPort;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveAllPort<DOM extends MkDomain>
	extends MkInsertAllPort<DOM>,
	MkUpdateAllPort<DOM>,
	MkUpsertAllPort<DOM>,
	MkMergeAllPort<DOM> {

	List<DOM> saveAll(List<MkSave<DOM>> saves);

}
