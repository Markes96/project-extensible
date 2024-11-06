package org.mk96.extensible.api.crud.domain.port.delete.filter.one;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkDeleteOneByFilterPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM deleteOne(MkFilter<DOM> filter);

}
