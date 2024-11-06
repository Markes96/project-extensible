package org.mk96.extensible.api.crud.infrastructure.http.id.type.string.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdFindService;
import org.mk96.extensible.api.crud.infrastructure.http.id.type.string.MkStringIdFindController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

public class MkStringIdFindControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkStringIdFindController<REQ, DOM, RES> {

	@Autowired
	protected MkIdFindService<DOM, String> service;

	public MkStringIdFindControllerImpl(
			final MkIdFindService<DOM, String> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES find(@PathVariable("id") final String id) {
		final DOM domResponse = this.service.find(id);
		return this.mapper.map(domResponse);
	}

}
