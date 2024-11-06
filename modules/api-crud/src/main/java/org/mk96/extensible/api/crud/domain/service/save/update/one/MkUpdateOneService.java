package org.mk96.extensible.api.crud.domain.service.save.update.one;

import org.mk96.extensible.api.crud.type.save.safe.update.MkUpdateSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkUpdateOneService<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM updateOne(MkUpdateSave<DOM> update);

}
