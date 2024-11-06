package org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge;

import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.all.MkMergeAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.many.MkMergeManyController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.one.MkMergeOneController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkMergeController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkMergeOneController<BOD, RES>,
	MkMergeManyController<BOD, RES>,
	MkMergeAllController<BOD, RES> {}
