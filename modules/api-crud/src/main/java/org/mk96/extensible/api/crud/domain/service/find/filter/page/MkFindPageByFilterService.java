package org.mk96.extensible.api.crud.domain.service.find.filter.page;

import java.util.List;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;
import org.springframework.data.domain.Pageable;

public interface MkFindPageByFilterService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> findPageByFilter(MkFilter<DOM> filter, Pageable pageable);

}
