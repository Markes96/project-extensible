package org.mk96.extensible.api.crud.domain.service.find.filter.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkFindAllByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> findAll(List<MkFilter<DOM>> filters);

}
