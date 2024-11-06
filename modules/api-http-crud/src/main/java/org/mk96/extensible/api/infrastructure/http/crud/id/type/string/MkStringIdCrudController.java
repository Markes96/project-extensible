package org.mk96.extensible.api.infrastructure.http.crud.id.type.string;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkStringIdCrudController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkStringIdCreateController<REQ, DOM, RES>,
	MkStringIdUpdateController<REQ, DOM, RES>,
	MkStringIdFindController<REQ, DOM, RES>,
	MkStringIdDeleteController<REQ, DOM, RES> {}
