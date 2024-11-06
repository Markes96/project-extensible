package org.mk96.extensible.api.crud.domain.port.find.id;

import org.mk96.extensible.api.crud.domain.port.find.id.all.MkFindAllByIdPort;
import org.mk96.extensible.api.crud.domain.port.find.id.one.MkFindOneByIdPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindByIdPort<DOM extends MkDomain, ID>
	extends MkFindOneByIdPort<DOM, ID>, MkFindAllByIdPort<DOM, ID> {}
