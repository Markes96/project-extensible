package org.mk96.extensible.api.crud.domain.service.delete.filter.one;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkDeleteOneByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	DOM deleteOne(MkFilter<DOM> filter);

}
