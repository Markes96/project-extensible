package org.mk96.extensible.api.crud.infrastructure.http.controller.find.id;

import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.all.MkFindAllByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.one.MkFindOneByIdController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkFindByIdController<BOD extends MkRestResponseDto, ID>
	extends MkFindOneByIdController<BOD, ID>,
	MkFindAllByIdController<BOD, ID> {}
