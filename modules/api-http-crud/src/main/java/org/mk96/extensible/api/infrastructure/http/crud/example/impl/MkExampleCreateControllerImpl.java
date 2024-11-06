package org.mk96.extensible.api.infrastructure.http.crud.example.impl;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleCreateService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.example.MkExampleCreateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkExampleCreateControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkExampleCreateController<REQ, DOM, RES> {

	@Autowired
	protected MkExampleCreateService<DOM> service;

	public MkExampleCreateControllerImpl(
			final MkExampleCreateService<DOM> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES create(@RequestBody final REQ body) {
		final DOM domRequest = mapper.map(body);
		final DOM domResponse = service.create(domRequest);
		return mapper.map(domResponse);
	}

}
