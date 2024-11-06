package org.mk96.extensible.api.infrastructure.http.crud.example.impl;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleCrudService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastructure.http.crud.example.MkExampleCrudController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkExampleCrudControllerImpl<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends AbstractMkController<REQ, DOM, RES>
	implements MkExampleCrudController<REQ, DOM, RES> {

	@Autowired
	protected MkExampleCrudService<DOM> service;

	public MkExampleCrudControllerImpl(
			final MkExampleCrudService<DOM> service,
			final MkControllerMapper<REQ, DOM, RES> mapper) {
		this.service = service;
		super.mapper = mapper;
		this.init_crud_controller();
	}

	@Delegate
	private MkExampleCreateControllerImpl<REQ, DOM, RES> createController;

	@Delegate
	private MkExampleUpdateControllerImpl<REQ, DOM, RES> updateController;

	@Delegate
	private MkExampleFindControllerImpl<REQ, DOM, RES> findController;

	@Delegate
	private MkExampleDeleteControllerImpl<REQ, DOM, RES> deleteController;

	@PostConstruct
	void init_crud_controller() {
		createController = new MkExampleCreateControllerImpl<>(service, mapper);
		updateController = new MkExampleUpdateControllerImpl<>(service, mapper);
		findController = new MkExampleFindControllerImpl<>(service, mapper);
		deleteController = new MkExampleDeleteControllerImpl<>(service, mapper);
	}

}
