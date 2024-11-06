package org.mk96.extensible.api.crud.infrastructure.http.controller.find;

import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.MkFindByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.MkFindByIdController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkFindController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto, ID>
	extends MkFindByFilterController<BOD, RES>,
	MkFindByIdController<RES, ID> {}
