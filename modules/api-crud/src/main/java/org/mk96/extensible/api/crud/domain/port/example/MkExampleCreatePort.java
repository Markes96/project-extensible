package org.mk96.extensible.api.crud.domain.port.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkExampleCreatePort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM create(DOM dom);

}
