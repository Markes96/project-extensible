package org.mk96.extensible.api.crud.domain.service.find.id.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkFindAllByIdService<DOM extends MkDomain, ID>
	extends MkService<DOM> {
	
	List<DOM> findAllById(List<ID> ids);
	
}
