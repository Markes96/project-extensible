package org.mk96.extensible.api.infrastructure.http.mapper;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkControllerMapper<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto> {

	DOM map(REQ request);

	RES map(DOM request);

}
