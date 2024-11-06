package org.mk96.extensible.api.crud.domain.service.delete.filter.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkDeleteAllByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> deleteAll(List<MkFilter<DOM>> filters);

}
