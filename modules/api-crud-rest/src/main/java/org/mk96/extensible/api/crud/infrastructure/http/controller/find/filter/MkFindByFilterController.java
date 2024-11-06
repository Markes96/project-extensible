package org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter;

import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.all.MkFindAllByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.many.MkFindManyByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.one.MkFindOneByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.page.MkFindPageByFilterController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkFindByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkFindOneByFilterController<BOD, RES>,
	MkFindManyByFilterController<BOD, RES>,
	MkFindAllByFilterController<BOD, RES>,
	MkFindPageByFilterController<BOD, RES> {}
