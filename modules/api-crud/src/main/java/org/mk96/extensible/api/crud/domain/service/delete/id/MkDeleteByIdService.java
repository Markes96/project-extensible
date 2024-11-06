package org.mk96.extensible.api.crud.domain.service.delete.id;

import org.mk96.extensible.api.crud.domain.service.delete.id.all.MkDeleteAllByIdService;
import org.mk96.extensible.api.crud.domain.service.delete.id.one.MkDeleteOneByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeleteByIdService<DOM extends MkDomain, ID>
	extends MkDeleteOneByIdService<DOM, ID>, 
	MkDeleteAllByIdService<DOM, ID> {}
