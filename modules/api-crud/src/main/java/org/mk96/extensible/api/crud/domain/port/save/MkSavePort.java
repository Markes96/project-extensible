package org.mk96.extensible.api.crud.domain.port.save;

import org.mk96.extensible.api.crud.domain.port.save.insert.MkInsertPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.MkMergePort;
import org.mk96.extensible.api.crud.domain.port.save.update.MkUpdatePort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.MkUpsertPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSavePort<DOM extends MkDomain>
	extends MkInsertPort<DOM>,
	MkMergePort<DOM>,
	MkUpdatePort<DOM>,
	MkUpsertPort<DOM> {}
