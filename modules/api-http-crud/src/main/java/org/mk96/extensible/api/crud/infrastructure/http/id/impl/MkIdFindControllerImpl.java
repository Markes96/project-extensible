package org.mk96.extensible.api.crud.infrastructure.http.id.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdFindService;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdFindController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkIdFindControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkIdFindController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdFindService<DOM, ID> service;

	public MkIdFindControllerImpl(
			final MkIdFindService<DOM, ID> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
	}

	@Override
	public RES find(@PathVariable("id") final ID id) {
		final DOM domResponse = this.service.find(id);
		return this.mapper.map(domResponse);
	}

}
