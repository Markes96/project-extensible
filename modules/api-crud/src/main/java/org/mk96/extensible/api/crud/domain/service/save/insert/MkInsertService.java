package org.mk96.extensible.api.crud.domain.service.save.insert;

import org.mk96.extensible.api.crud.domain.service.save.insert.all.MkInsertAllService;
import org.mk96.extensible.api.crud.domain.service.save.insert.one.MkInsertOneService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkInsertService<DOM extends MkDomain>
	extends MkInsertOneService<DOM>,
	MkInsertAllService<DOM> {}
