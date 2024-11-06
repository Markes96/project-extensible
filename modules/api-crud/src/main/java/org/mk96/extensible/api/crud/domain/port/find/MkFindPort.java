package org.mk96.extensible.api.crud.domain.port.find;

import org.mk96.extensible.api.crud.domain.port.find.filter.MkFindByFilterPort;
import org.mk96.extensible.api.crud.domain.port.find.id.MkFindByIdPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkFindPort<DOM extends MkDomain, ID>
	extends MkFindByFilterPort<DOM>, MkFindByIdPort<DOM, ID> {}
