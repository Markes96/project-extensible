package org.mk96.extensible.api.crud.domain.service.save;

import org.mk96.extensible.api.crud.domain.service.save.all.MkSaveAllService;
import org.mk96.extensible.api.crud.domain.service.save.one.MkSaveOneService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSaveService<DOM extends MkDomain>
	extends MkSaveOneService<DOM>,
	MkSaveAllService<DOM> {}
