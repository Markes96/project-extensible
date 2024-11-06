package org.mk96.extensible.api.crud.domain.port.get.all;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkGetAllPort<DOM extends MkDomain> 
	extends MkPort<DOM> {
	
	List<DOM> getAll();
	
}
