package org.mk96.extensible.api.infrastructure.http.crud.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkExampleCrudController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkExampleCreateController<REQ, DOM, RES>,
	MkExampleUpdateController<REQ, DOM, RES>,
	MkExampleFindController<REQ, DOM, RES>,
	MkExampleDeleteController<REQ, DOM, RES> {}
