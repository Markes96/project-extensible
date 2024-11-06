package org.mk96.extensible.api.crud.domain.service.example;

import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkExampleCrudService<DOM extends MkDomain>
	extends MkExampleCreateService<DOM>,
	MkExampleUpdateService<DOM>,
	MkExampleFindService<DOM>,
	MkExampleDeleteService<DOM> {}