package org.mk96.extensible.api.crud.domain.service.save.insert.one;

import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkInsertOneService<DOM extends MkDomain>
	extends MkService<DOM> {

	DOM insertOne(MkInsertSave<DOM> insert);

}
