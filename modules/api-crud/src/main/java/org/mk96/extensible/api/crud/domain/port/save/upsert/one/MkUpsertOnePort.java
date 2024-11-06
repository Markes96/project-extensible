package org.mk96.extensible.api.crud.domain.port.save.upsert.one;

import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkUpsertOnePort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM upsertOne(MkUpsertSave<DOM> upsert);

}
