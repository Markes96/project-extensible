package org.mk96.extensible.api.crud.domain.port.find.filter;

import org.mk96.extensible.api.crud.domain.port.find.filter.all.MkFindAllByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.many.MkFindManyByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.filter.one.MkFindOneByFilterPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindByFilterPort<DOM extends MkDomain>
	extends MkFindOneByFilterPort<DOM>,
	MkFindManyByFilterPort<DOM>,
	MkFindAllByFilterPort<DOM> {}
