package org.mk96.extensible.api.infrastructure.http.crud.id.type.number;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.MkTypeIdUpdateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkNumberIdUpdateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID extends Number>
	extends MkTypeIdUpdateController<REQ, DOM, RES, ID> {}
