package org.mk96.extensible.api.crud.domain.port.find.id.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkFindAllByIdPort<DOM extends MkDomain, ID>
	extends MkPort<DOM> {
	
	List<DOM> findAllById(List<ID> ids);
	
}
