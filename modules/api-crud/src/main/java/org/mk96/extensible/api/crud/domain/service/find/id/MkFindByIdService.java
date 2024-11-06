package org.mk96.extensible.api.crud.domain.service.find.id;

import org.mk96.extensible.api.crud.domain.service.find.id.all.MkFindAllByIdService;
import org.mk96.extensible.api.crud.domain.service.find.id.one.MkFindOneByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindByIdService<DOM extends MkDomain, ID>
	extends MkFindOneByIdService<DOM, ID>,
	MkFindAllByIdService<DOM, ID> {}
