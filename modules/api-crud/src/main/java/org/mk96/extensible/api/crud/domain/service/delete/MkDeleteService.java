package org.mk96.extensible.api.crud.domain.service.delete;

import org.mk96.extensible.api.crud.domain.service.delete.filter.MkDeleteByFilterService;
import org.mk96.extensible.api.crud.domain.service.delete.id.MkDeleteByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeleteService<DOM extends MkDomain, ID>
	extends MkDeleteByFilterService<DOM>, 
	MkDeleteByIdService<DOM, ID> {}
