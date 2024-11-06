package org.mk96.extensible.api.crud.domain.service;

import org.mk96.extensible.api.crud.domain.service.delete.MkDeleteService;
import org.mk96.extensible.api.crud.domain.service.find.MkFindService;
import org.mk96.extensible.api.crud.domain.service.save.MkSaveService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkCrudService<DOM extends MkDomain, ID>
	extends MkFindService<DOM, ID>,
	MkDeleteService<DOM, ID>,
	MkSaveService<DOM> {}
