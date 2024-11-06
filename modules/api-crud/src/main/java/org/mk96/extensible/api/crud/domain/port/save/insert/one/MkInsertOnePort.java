package org.mk96.extensible.api.crud.domain.port.save.insert.one;

import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkInsertOnePort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM insertOne(MkInsertSave<DOM> insert);

}
