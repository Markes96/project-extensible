package org.mk96.extensible.api.crud.infrastructure.http.id.impl;

import org.mk96.extensible.api.crud.domain.service.id.MkIdCrudService;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdCreateController;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdCrudController;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdDeleteController;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdFindController;
import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdUpdateController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor
public class MkIdCrudControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkIdCrudController<REQ, DOM, RES, ID> {

	@Autowired
	protected MkIdCrudService<DOM, ID> service;

	public MkIdCrudControllerImpl(
			final MkIdCrudService<DOM, ID> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
		this.init_crud_controller();
	}

	@Delegate
	private MkIdCreateController<REQ, DOM, RES, ID> createController;

	@Delegate
	private MkIdUpdateController<REQ, DOM, RES, ID> updateController;

	@Delegate
	private MkIdFindController<REQ, DOM, RES, ID> findController;

	@Delegate
	private MkIdDeleteController<REQ, DOM, RES, ID> deleteController;

	@PostConstruct
	void init_crud_controller() {
		this.createController = new MkIdCreateControllerImpl<>(this.service, this.mapper);
		this.updateController = new MkIdUpdateControllerImpl<>(this.service, this.mapper);
		this.findController = new MkIdFindControllerImpl<>(this.service, this.mapper);
		this.deleteController = new MkIdDeleteControllerImpl<>(this.service);
	}

}
