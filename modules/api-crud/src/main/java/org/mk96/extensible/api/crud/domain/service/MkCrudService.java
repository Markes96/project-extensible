package org.mk96.extensible.api.crud.domain.service;

import org.mk96.extensible.api.crud.domain.service.example.MkExampleCrudService;
import org.mk96.extensible.api.crud.domain.service.id.MkIdCrudService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkCrudService<DOM extends MkDomain, ID>
	extends MkExampleCrudService<DOM>, MkIdCrudService<DOM, ID> {}
