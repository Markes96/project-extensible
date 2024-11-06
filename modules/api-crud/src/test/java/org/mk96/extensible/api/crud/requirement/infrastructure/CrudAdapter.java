package org.mk96.extensible.api.crud.requirement.infrastructure;

import org.mk96.extensible.api.crud.domain.port.example.MkExampleCreatePort;
import org.mk96.extensible.api.crud.domain.port.example.MkExampleDeletePort;
import org.mk96.extensible.api.crud.requirement.domain.model.DomainObject;
import org.springframework.stereotype.Service;

@Service
public class CrudAdapter
	implements MkExampleCreatePort<DomainObject>, MkExampleDeletePort<DomainObject> {

	@Override
	public DomainObject create(final DomainObject dom) {
		return new DomainObject(1, 2);
	}

	@Override
	public DomainObject delete(final DomainObject dom) {
		return new DomainObject(1, 2);
	}

}
