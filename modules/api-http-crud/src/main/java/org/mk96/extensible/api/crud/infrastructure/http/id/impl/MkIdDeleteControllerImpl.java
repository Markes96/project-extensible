package org.mk96.extensible.api.crud.infrastructure.http.id.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdDeleteService;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdDeleteController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MkIdDeleteControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkIdDeleteController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdDeleteService<DOM, ID> service;

	public MkIdDeleteControllerImpl(
			final MkIdDeleteService<DOM, ID> service) {
		this.service = service;
	}

	@Override
	public void delete(@PathVariable("id") final ID id) {
		this.service.delete(id);
	}

}
