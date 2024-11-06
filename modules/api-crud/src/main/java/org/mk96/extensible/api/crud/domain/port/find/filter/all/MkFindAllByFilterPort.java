package org.mk96.extensible.api.crud.domain.port.find.filter.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkFindAllByFilterPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> findAll(List<MkFilter<DOM>> filters);

}
