package org.mk96.extensible.api.crud.domain.service.get;

import org.mk96.extensible.api.crud.domain.service.get.all.MkGetAllService;
import org.mk96.extensible.api.crud.domain.service.get.page.MkGetPageService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkGetService<DOM extends MkDomain>
	extends MkGetAllService<DOM>,
	MkGetPageService<DOM> {}
