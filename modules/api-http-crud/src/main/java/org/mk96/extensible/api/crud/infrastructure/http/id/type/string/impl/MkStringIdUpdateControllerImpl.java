package org.mk96.extensible.api.crud.infrastructure.http.id.type.string.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdUpdateService;
import org.mk96.extensible.api.crud.infrastructure.http.id.type.string.MkStringIdUpdateController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class MkStringIdUpdateControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkStringIdUpdateController<REQ, DOM, RES> {

	@Autowired
	protected MkIdUpdateService<DOM, String> service;

	public MkStringIdUpdateControllerImpl(
			final MkIdUpdateService<DOM, String> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES update(@PathVariable("id") final String id, @RequestBody final REQ body) {
		final DOM domRequest = this.mapper.map(body);
		final DOM domResponse = this.service.update(id, domRequest);
		return this.mapper.map(domResponse);
	}

}
