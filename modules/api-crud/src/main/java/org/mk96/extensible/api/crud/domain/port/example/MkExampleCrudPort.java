package org.mk96.extensible.api.crud.domain.port.example;

import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkExampleCrudPort<DOM extends MkDomain>
	extends MkExampleCreatePort<DOM>,
	MkExampleUpdatePort<DOM>,
	MkExampleFindPort<DOM>,
	MkExampleDeletePort<DOM> {}