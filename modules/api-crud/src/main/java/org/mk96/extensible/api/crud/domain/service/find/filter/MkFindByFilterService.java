package org.mk96.extensible.api.crud.domain.service.find.filter;

import org.mk96.extensible.api.crud.domain.service.find.filter.all.MkFindAllByFilterService;
import org.mk96.extensible.api.crud.domain.service.find.filter.many.MkFindManyByFilterService;
import org.mk96.extensible.api.crud.domain.service.find.filter.one.MkFindOneByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindByFilterService<DOM extends MkDomain>
	extends MkFindOneByFilterService<DOM>,
	MkFindManyByFilterService<DOM>,
	MkFindAllByFilterService<DOM> {}
