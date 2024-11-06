package org.mk96.extensible.api.crud.domain.port.find.id.one;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkFindOneByIdPort<DOM extends MkDomain, ID>
	extends MkPort<DOM> {

	DOM findOneById(ID id);
	
}
