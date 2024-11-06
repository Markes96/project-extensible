package org.mk96.extensible.api.crud.domain.service.find;

import org.mk96.extensible.api.crud.domain.service.find.filter.MkFindByFilterService;
import org.mk96.extensible.api.crud.domain.service.find.id.MkFindByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindService<DOM extends MkDomain, ID>
	extends MkFindByFilterService<DOM>,
	MkFindByIdService<DOM, ID> {}
