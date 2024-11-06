package org.mk96.extensible.api.crud.domain.service.save.upsert.one;

import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkUpsertOneService<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM upsertOne(MkUpsertSave<DOM> upsert);

}
