package org.mk96.extensible.api.infrastructure.http;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;

public interface MkController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto> {}
