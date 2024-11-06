package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id;

import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.all.MkDeleteAllByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.one.MkDeleteOneByIdController;

public interface MkDeleteByIdController<ID>
	extends MkDeleteOneByIdController<ID>,
	MkDeleteAllByIdController<ID> {}
