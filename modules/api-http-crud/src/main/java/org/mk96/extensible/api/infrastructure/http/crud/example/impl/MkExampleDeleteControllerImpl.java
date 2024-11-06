package org.mk96.extensible.api.infrastructure.http.crud.example.impl;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleDeleteService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.example.MkExampleDeleteController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkExampleDeleteControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkExampleDeleteController<REQ, DOM, RES> {

	@Autowired
	protected MkExampleDeleteService<DOM> service;

	public MkExampleDeleteControllerImpl(
			final MkExampleDeleteService<DOM> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES delete(@RequestBody final REQ body) {
		final DOM domRequest = mapper.map(body);
		final DOM domResponse = service.delete(domRequest);
		return mapper.map(domResponse);
	}

}
