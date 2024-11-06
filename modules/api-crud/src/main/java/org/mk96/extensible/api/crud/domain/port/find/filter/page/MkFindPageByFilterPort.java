package org.mk96.extensible.api.crud.domain.port.find.filter.page;

import java.util.List;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;
import org.springframework.data.domain.Pageable;

public interface MkFindPageByFilterPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> findPageByFilter(MkFilter<DOM> filter, Pageable pageable);

}
