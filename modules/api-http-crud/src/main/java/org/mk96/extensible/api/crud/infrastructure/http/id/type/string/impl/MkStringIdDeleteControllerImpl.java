package org.mk96.extensible.api.crud.infrastructure.http.id.type.string.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdDeleteService;
import org.mk96.extensible.api.crud.infrastructure.http.id.type.string.MkStringIdDeleteController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

public class MkStringIdDeleteControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkStringIdDeleteController<REQ, DOM, RES> {

	@Autowired
	protected MkIdDeleteService<DOM, String> service;

	public MkStringIdDeleteControllerImpl(
			final MkIdDeleteService<DOM, String> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public void delete(@PathVariable("id") final String id) {
		this.service.delete(id);
	}

}
