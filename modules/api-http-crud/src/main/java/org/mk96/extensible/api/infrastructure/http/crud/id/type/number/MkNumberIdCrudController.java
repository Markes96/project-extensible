package org.mk96.extensible.api.infrastructure.http.crud.id.type.number;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkNumberIdCrudController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID extends Number>
	extends MkNumberIdCreateController<REQ, DOM, RES, ID>,
	MkNumberIdUpdateController<REQ, DOM, RES, ID>,
	MkNumberIdFindController<REQ, DOM, RES, ID>,
	MkNumberIdDeleteController<REQ, DOM, RES, ID> {}
