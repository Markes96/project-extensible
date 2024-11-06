package org.mk96.extensible.api.crud.domain.port.get;

import org.mk96.extensible.api.crud.domain.port.get.all.MkGetAllPort;
import org.mk96.extensible.api.crud.domain.port.get.page.MkGetPagePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkGetPort<DOM extends MkDomain>
	extends MkGetAllPort<DOM>,
	MkGetPagePort<DOM> {}
