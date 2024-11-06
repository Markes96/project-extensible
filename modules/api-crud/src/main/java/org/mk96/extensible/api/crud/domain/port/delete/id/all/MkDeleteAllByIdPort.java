package org.mk96.extensible.api.crud.domain.port.delete.id.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkDeleteAllByIdPort<DOM extends MkDomain, ID>
	extends MkPort<DOM> {
	
	void deleteAllById(List<ID> ids);
	
}
