package org.mk96.extensible.api.crud.infrastructure.http.controller;

import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.MkDeleteController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.MkFindController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.MkGetController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.MkSaveController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkCrudController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto, ID>
	extends MkGetController<RES>,
	MkFindController<BOD, RES, ID>,
	MkDeleteController<BOD, RES, ID>,
	MkSaveController<BOD, RES> {}
