package org.mk96.extensible.api.crud.domain.service.delete.filter;

import org.mk96.extensible.api.crud.domain.service.delete.filter.all.MkDeleteAllByFilterService;
import org.mk96.extensible.api.crud.domain.service.delete.filter.many.MkDeleteManyByFilterService;
import org.mk96.extensible.api.crud.domain.service.delete.filter.one.MkDeleteOneByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeleteByFilterService<DOM extends MkDomain>
	extends MkDeleteOneByFilterService<DOM>,
	MkDeleteManyByFilterService<DOM>,
	MkDeleteAllByFilterService<DOM> {}
