package org.mk96.extensible.api.crud.domain.port.delete.id;

import org.mk96.extensible.api.crud.domain.port.delete.id.all.MkDeleteAllByIdPort;
import org.mk96.extensible.api.crud.domain.port.delete.id.one.MkDeleteOneByIdPort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkDeleteByIdPort<DOM extends MkDomain, ID>
	extends MkDeleteOneByIdPort<DOM, ID>, MkDeleteAllByIdPort<DOM, ID> {}
