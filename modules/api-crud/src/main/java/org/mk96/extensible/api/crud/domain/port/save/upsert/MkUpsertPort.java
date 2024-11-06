package org.mk96.extensible.api.crud.domain.port.save.upsert;

import org.mk96.extensible.api.crud.domain.port.save.upsert.all.MkUpsertAllPort;
import org.mk96.extensible.api.crud.domain.port.save.upsert.one.MkUpsertOnePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkUpsertPort<DOM extends MkDomain>
	extends MkUpsertOnePort<DOM>,
	MkUpsertAllPort<DOM> {}
