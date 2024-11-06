package org.mk96.extensible.api.crud.requirement.application;

import org.mk96.extensible.api.crud.application.example.MkExampleCrudUseCase;
import org.mk96.extensible.api.crud.requirement.domain.model.DomainObject;
import org.mk96.extensible.api.crud.requirement.domain.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class CrudUseCase
	extends MkExampleCrudUseCase<DomainObject>
	implements CrudService {}
