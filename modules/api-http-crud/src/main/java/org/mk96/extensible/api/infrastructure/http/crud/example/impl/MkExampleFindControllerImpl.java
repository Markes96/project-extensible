package org.mk96.extensible.api.infrastructure.http.crud.example.impl;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleFindService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.example.MkExampleFindController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkExampleFindControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkExampleFindController<REQ, DOM, RES> {

	@Autowired
	protected MkExampleFindService<DOM> service;

	public MkExampleFindControllerImpl(
			final MkExampleFindService<DOM> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES find(@RequestBody final REQ body) {
		final DOM domRequest = mapper.map(body);
		final DOM domResponse = service.find(domRequest);
		return mapper.map(domResponse);
	}

}
