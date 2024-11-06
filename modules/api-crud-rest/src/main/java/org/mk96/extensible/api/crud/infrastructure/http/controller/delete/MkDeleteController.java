package org.mk96.extensible.api.crud.infrastructure.http.controller.delete;

import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.MkDeleteByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.MkDeleteByIdController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkDeleteController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto, ID>
	extends MkDeleteByFilterController<BOD, RES>,
	MkDeleteByIdController<ID> {}
