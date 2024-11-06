package org.mk96.extensible.api.crud.domain.service.get.page;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;
import org.springframework.data.domain.Pageable;

public interface MkGetPageService<DOM extends MkDomain> 
	extends MkService<DOM> {

	List<DOM> getPage(Pageable pageable);
	
}
