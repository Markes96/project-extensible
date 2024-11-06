package org.mk96.extensible.api.crud.infrastructure.http.controller.save.update;

import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.all.MkUpdateAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.one.MkUpdateOneController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkUpdateController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkUpdateOneController<BOD, RES>,
	MkUpdateAllController<BOD, RES> {}
