package org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert;

import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.all.MkUpsertAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.one.MkUpsertOneController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkUpsertController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkUpsertOneController<BOD, RES>,
	MkUpsertAllController<BOD, RES> {}
