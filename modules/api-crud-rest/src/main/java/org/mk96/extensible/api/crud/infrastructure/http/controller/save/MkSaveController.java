package org.mk96.extensible.api.crud.infrastructure.http.controller.save;

import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.MkInsertController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.MkMergeController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.MkUpdateController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.MkUpsertController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkSaveController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkInsertController<BOD, RES>,
	MkMergeController<BOD, RES>,
	MkUpdateController<BOD, RES>,
	MkUpsertController<BOD, RES> {}
