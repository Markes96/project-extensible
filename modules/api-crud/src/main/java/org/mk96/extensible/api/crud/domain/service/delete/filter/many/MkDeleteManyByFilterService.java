package org.mk96.extensible.api.crud.domain.service.delete.filter.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkDeleteManyByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> deleteMany(MkFilter<DOM> filter);

}
