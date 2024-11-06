package org.mk96.extensible.api.crud.infrastructure.mapper;

import org.mk96.extensible.api.crud.infrastructure.dto.MkData;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkCrudMapper<DOM extends MkDomain, DATA extends MkData> {

	DOM map(DATA data);

	DATA map(DOM domain);
	
	default DATA update(DATA data) {
		String typeName = data.getClass().getSimpleName();
		throw new MkCrudException(typeName + " update not implemented");
	}

}
