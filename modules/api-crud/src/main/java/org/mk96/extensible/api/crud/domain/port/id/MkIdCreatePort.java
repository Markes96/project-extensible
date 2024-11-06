package org.mk96.extensible.api.crud.domain.port.id;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkIdCreatePort<DOM extends MkDomain, ID>
	extends MkPort<DOM> {

	DOM create(ID id, DOM dom);

}
