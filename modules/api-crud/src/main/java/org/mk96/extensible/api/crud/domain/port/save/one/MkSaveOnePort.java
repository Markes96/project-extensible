package org.mk96.extensible.api.crud.domain.port.save.one;

import org.mk96.extensible.api.crud.domain.port.save.insert.one.MkInsertOnePort;
import org.mk96.extensible.api.crud.domain.port.save.merge.one.MkMergeOnePort;
import org.mk96.extensible.api.crud.domain.port.save.update.one.MkUpdateOnePort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.one.MkUpsertOnePort;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveOnePort<DOM extends MkDomain>
	extends MkInsertOnePort<DOM>,
	MkUpdateOnePort<DOM>,
	MkUpsertOnePort<DOM>,
	MkMergeOnePort<DOM> {

	DOM saveOne(MkSave<DOM> save);

}
