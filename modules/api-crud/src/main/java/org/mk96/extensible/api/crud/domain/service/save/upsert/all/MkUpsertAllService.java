package org.mk96.extensible.api.crud.domain.service.save.upsert.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkUpsertAllService<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> upsertAll(List<MkUpsertSave<DOM>> upserts);

}
