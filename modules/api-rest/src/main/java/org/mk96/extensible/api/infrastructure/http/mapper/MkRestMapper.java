package org.mk96.extensible.api.infrastructure.http.mapper;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.body.MkRestBodyMapper;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;

public interface MkRestMapper<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends MkRestBodyMapper<BOD, DOM>,
    MkRestResponseMapper<DOM, RES> {}
