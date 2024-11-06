package org.mk96.extensible.api.infrastructure.http.crud.id.type.string.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdCrudService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.string.MkStringIdCreateController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.string.MkStringIdCrudController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.string.MkStringIdDeleteController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.string.MkStringIdFindController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.string.MkStringIdUpdateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.experimental.Delegate;

public class MkStringIdCrudControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkStringIdCrudController<REQ, DOM, RES> {

	@Autowired
	protected MkIdCrudService<DOM, String> service;

	public MkStringIdCrudControllerImpl(
			final MkIdCrudService<DOM, String> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
		this.init_crud_controller();
	}

	@Delegate
	private MkStringIdCreateController<REQ, DOM, RES> createController;

	@Delegate
	private MkStringIdUpdateController<REQ, DOM, RES> updateController;

	@Delegate
	private MkStringIdFindController<REQ, DOM, RES> findController;

	@Delegate
	private MkStringIdDeleteController<REQ, DOM, RES> deleteController;

	@PostConstruct
	void init_crud_controller() {
		this.createController = new MkStringIdCreateControllerImpl<>(this.service, this.mapper);
		this.updateController = new MkStringIdUpdateControllerImpl<>(this.service, this.mapper);
		this.findController = new MkStringIdFindControllerImpl<>(this.service, this.mapper);
		this.deleteController = new MkStringIdDeleteControllerImpl<>(this.service, this.mapper);
	}

}
