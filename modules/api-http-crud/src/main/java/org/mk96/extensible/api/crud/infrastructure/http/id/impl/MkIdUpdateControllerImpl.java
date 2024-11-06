package org.mk96.extensible.api.crud.infrastructure.http.id.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdUpdateService;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdUpdateController;
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
public class MkIdUpdateControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkIdUpdateController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdUpdateService<DOM, ID> service;

	public MkIdUpdateControllerImpl(
			final MkIdUpdateService<DOM, ID> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES update(@PathVariable("id") final ID id, @RequestBody final REQ body) {
		final DOM domRequest = this.mapper.map(body);
		final DOM domResponse = this.service.update(id, domRequest);
		return this.mapper.map(domResponse);
	}

}
