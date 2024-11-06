package org.mk96.extensible.api.crud.domain.port.delete.id.one;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkDeleteOneByIdPort<DOM extends MkDomain, ID>
	extends MkPort<DOM> {

	void deleteOneById(ID id);
	
}
