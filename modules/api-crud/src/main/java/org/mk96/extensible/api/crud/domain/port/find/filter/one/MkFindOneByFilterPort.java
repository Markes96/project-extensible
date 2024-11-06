package org.mk96.extensible.api.crud.domain.port.find.filter.one;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkFindOneByFilterPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM findOne(MkFilter<DOM> filter);

}
