package org.mk96.extensible.api.crud.domain.service.find.filter.one;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkFindOneByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	DOM findOne(MkFilter<DOM> filter);

}
