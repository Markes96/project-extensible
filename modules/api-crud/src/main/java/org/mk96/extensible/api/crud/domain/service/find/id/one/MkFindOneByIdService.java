package org.mk96.extensible.api.crud.domain.service.find.id.one;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkFindOneByIdService<DOM extends MkDomain, ID>
	extends MkService<DOM> {

	DOM findOneById(ID id);
	
}
