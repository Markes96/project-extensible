package org.mk96.extensible.api.infrastructure.http.crud.id.type.number;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.MkTypeIdCreateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkNumberIdCreateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID extends Number>
	extends MkTypeIdCreateController<REQ, DOM, RES, ID> {}
