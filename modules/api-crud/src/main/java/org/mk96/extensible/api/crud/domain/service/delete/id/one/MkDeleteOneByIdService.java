package org.mk96.extensible.api.crud.domain.service.delete.id.one;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkDeleteOneByIdService<DOM extends MkDomain, ID>
	extends MkService<DOM> {

	void deleteOneById(ID id);
	
}
