package org.mk96.extensible.api.infrastructure.http;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMkController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto> {

	@Autowired
	protected MkService<DOM> service;
	
	@Autowired
	protected MkControllerMapper<REQ, DOM, RES> mapper;

}
