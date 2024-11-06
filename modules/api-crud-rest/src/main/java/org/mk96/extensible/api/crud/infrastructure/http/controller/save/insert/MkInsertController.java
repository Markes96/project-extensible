package org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert;

import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.all.MkInsertAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.one.MkInsertOneController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkInsertController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkInsertOneController<BOD, RES>,
	MkInsertAllController<BOD, RES> {}
