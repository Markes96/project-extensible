package org.mk96.extensible.api.infrastructure.http.crud.id;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkIdCrudController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkIdCreateController<REQ, DOM, RES, ID>,
	MkIdUpdateController<REQ, DOM, RES, ID>,
	MkIdFindController<REQ, DOM, RES, ID>,
	MkIdDeleteController<REQ, DOM, RES, ID> {}
