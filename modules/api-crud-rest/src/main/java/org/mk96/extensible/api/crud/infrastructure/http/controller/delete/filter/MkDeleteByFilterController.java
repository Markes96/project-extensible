package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter;

import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.all.MkDeleteAllByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.many.MkDeleteManyByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.one.MkDeleteOneByFilterController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkDeleteByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkDeleteOneByFilterController<BOD, RES>,
	MkDeleteManyByFilterController<BOD, RES>,
	MkDeleteAllByFilterController<BOD, RES> {}
