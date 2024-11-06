package org.mk96.extensible.api.crud.domain.port.delete.filter;

import org.mk96.extensible.api.crud.domain.port.delete.filter.all.MkDeleteAllByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.many.MkDeleteManyByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.filter.one.MkDeleteOneByFilterPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeleteByFilterPort<DOM extends MkDomain>
	extends MkDeleteOneByFilterPort<DOM>,
	MkDeleteManyByFilterPort<DOM>,
	MkDeleteAllByFilterPort<DOM> {}
