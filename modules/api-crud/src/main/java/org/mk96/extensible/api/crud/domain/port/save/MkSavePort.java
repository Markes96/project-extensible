package org.mk96.extensible.api.crud.domain.port.save;

import org.mk96.extensible.api.crud.domain.port.save.all.MkSaveAllPort;
import org.mk96.extensible.api.crud.domain.port.save.one.MkSaveOnePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkSavePort<DOM extends MkDomain>
	extends MkSaveOnePort<DOM>,
	MkSaveAllPort<DOM> {}
