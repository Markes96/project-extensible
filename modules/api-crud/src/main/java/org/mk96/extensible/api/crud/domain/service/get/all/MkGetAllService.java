package org.mk96.extensible.api.crud.domain.service.get.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkGetAllService<DOM extends MkDomain> 
	extends MkService<DOM> {
	
	List<DOM> getAll();
	
}
