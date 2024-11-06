package org.mk96.extensible.api.infrastructure.http.crud.id.type;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkTypeIdCrudController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkTypeIdCreateController<REQ, DOM, RES, ID>,
	MkTypeIdUpdateController<REQ, DOM, RES, ID>,
	MkTypeIdFindController<REQ, DOM, RES, ID>,
	MkTypeIdDeleteController<REQ, DOM, RES, ID> {}
