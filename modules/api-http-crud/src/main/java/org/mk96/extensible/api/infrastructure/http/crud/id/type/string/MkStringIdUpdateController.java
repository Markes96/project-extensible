package org.mk96.extensible.api.infrastructure.http.crud.id.type.string;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.MkTypeIdUpdateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkStringIdUpdateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkTypeIdUpdateController<REQ, DOM, RES, String> {}
