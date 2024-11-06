package org.mk96.extensible.api.crud.infrastructure.http.controller.get;

import org.mk96.extensible.api.crud.infrastructure.http.controller.get.all.MkGetAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.page.MkGetPageController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkGetController<RES extends MkRestResponseDto>
	extends MkGetAllController<RES>,
	MkGetPageController<RES> {}
