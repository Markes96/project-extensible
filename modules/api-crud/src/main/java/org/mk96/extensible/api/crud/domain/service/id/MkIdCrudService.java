package org.mk96.extensible.api.crud.domain.service.id;

import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkIdCrudService<DOM extends MkDomain, ID>
	extends MkIdCreateService<DOM, ID>,
	MkIdUpdateService<DOM, ID>,
	MkIdFindService<DOM, ID>,
	MkIdDeleteService<DOM, ID> {}