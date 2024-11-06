package org.mk96.extensible.api.crud.domain.service.delete.id.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkDeleteAllByIdService<DOM extends MkDomain, ID>
	extends MkService<DOM> {
	
	void deleteAllById(List<ID> ids);
	
}
