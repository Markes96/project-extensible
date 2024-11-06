package org.mk96.extensible.api.crud.domain.port.save.update;

import org.mk96.extensible.api.crud.domain.port.save.update.all.MkUpdateAllPort;
import org.mk96.extensible.api.crud.domain.port.save.update.one.MkUpdateOnePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkUpdatePort<DOM extends MkDomain>
	extends MkUpdateOnePort<DOM>,
	MkUpdateAllPort<DOM> {}
