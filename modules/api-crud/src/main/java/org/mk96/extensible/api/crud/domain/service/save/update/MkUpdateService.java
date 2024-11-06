package org.mk96.extensible.api.crud.domain.service.save.update;

import org.mk96.extensible.api.crud.domain.service.save.update.all.MkUpdateAllService;
import org.mk96.extensible.api.crud.domain.service.save.update.one.MkUpdateOneService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkUpdateService<DOM extends MkDomain>
	extends MkUpdateOneService<DOM>,
	MkUpdateAllService<DOM> {}
