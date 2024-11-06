package org.mk96.extensible.api.infrastructure.http.crud.id.type.number.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdCrudService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.number.MkNumberIdCreateController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.number.MkNumberIdCrudController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.number.MkNumberIdDeleteController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.number.MkNumberIdFindController;
import org.mk96.extensible.api.infrastructure.http.crud.id.type.number.MkNumberIdUpdateController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.experimental.Delegate;

public class MkNumberIdCrudControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID extends Number>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkNumberIdCrudController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdCrudService<DOM, ID> service;

	public MkNumberIdCrudControllerImpl(
			final MkIdCrudService<DOM, ID> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
		this.init_crud_controller();
	}

	@Delegate
	private MkNumberIdCreateController<REQ, DOM, RES, ID> createController;

	@Delegate
	private MkNumberIdUpdateController<REQ, DOM, RES, ID> updateController;

	@Delegate
	private MkNumberIdFindController<REQ, DOM, RES, ID> findController;

	@Delegate
	private MkNumberIdDeleteController<REQ, DOM, RES, ID> deleteController;

	@PostConstruct
	void init_crud_controller() {
		this.createController = new MkNumberIdCreateControllerImpl<>(this.service, this.mapper);
		this.updateController = new MkNumberIdUpdateControllerImpl<>(this.service, this.mapper);
		this.findController = new MkNumberIdFindControllerImpl<>(this.service, this.mapper);
		this.deleteController = new MkNumberIdDeleteControllerImpl<>(this.service, this.mapper);
	}

}
