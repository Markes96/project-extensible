package org.mk96.extensible.api.crud.domain.port.delete.filter.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkDeleteManyByFilterPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> deleteMany(MkFilter<DOM> filter);

}
