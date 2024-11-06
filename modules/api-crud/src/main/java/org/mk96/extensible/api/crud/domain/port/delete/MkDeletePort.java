package org.mk96.extensible.api.crud.domain.port.delete;

import org.mk96.extensible.api.crud.domain.port.delete.filter.MkDeleteByFilterPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.MkDeleteByIdPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeletePort<DOM extends MkDomain, ID>
	extends MkDeleteByFilterPort<DOM>, MkDeleteByIdPort<DOM, ID> {}
