package org.mk96.extensible.api.crud.infrastructure.http.id.type.string.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdCreateService;
import org.mk96.extensible.api.crud.infrastructure.http.id.type.string.MkStringIdCreateController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkStringIdCreateControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkStringIdCreateController<REQ, DOM, RES> {

	@Autowired
	protected MkIdCreateService<DOM, String> service;

	public MkStringIdCreateControllerImpl(
			final MkIdCreateService<DOM, String> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES create(@PathVariable("id") final String id, @RequestBody final REQ body) {
		final DOM domRequest = this.mapper.map(body);
		final DOM domResponse = this.service.create(id, domRequest);
		return this.mapper.map(domResponse);
	}

}
