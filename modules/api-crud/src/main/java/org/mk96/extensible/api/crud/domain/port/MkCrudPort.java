package org.mk96.extensible.api.crud.domain.port;

import org.mk96.extensible.api.crud.domain.port.delete.MkDeletePort;
import org.mk96.extensible.api.crud.domain.port.find.MkFindPort;
import org.mk96.extensible.api.crud.domain.port.save.MkSavePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkCrudPort<DOM extends MkDomain, ID>
	extends MkFindPort<DOM, ID>,
	MkDeletePort<DOM, ID>,
	MkSavePort<DOM> {}
