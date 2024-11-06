package org.mk96.extensible.api.crud.infrastructure.http.id.type.number.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdDeleteService;
import org.mk96.extensible.api.crud.infrastructure.http.id.type.number.MkNumberIdDeleteController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

public class MkNumberIdDeleteControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID extends Number>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkNumberIdDeleteController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdDeleteService<DOM, ID> service;

	public MkNumberIdDeleteControllerImpl(
			final MkIdDeleteService<DOM, ID> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public void delete(@PathVariable("id") final ID id) {
		this.service.delete(id);
	}

}
