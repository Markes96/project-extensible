package org.mk96.extensible.api.infrastructure.http.crud.id.type.string;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.MkTypeIdCreateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkStringIdCreateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkTypeIdCreateController<REQ, DOM, RES, String> {}
