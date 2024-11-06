package org.mk96.extensible.api.crud.requirement.domain.service;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleCreateService;
import org.mk96.extensible.api.crud.domain.service.example.MkExampleDeleteService;
import org.mk96.extensible.api.crud.requirement.domain.model.DomainObject;

public interface CrudService
	extends MkExampleCreateService<DomainObject>, MkExampleDeleteService<DomainObject> {

}
