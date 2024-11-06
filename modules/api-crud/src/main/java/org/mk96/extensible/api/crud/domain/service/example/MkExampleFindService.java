package org.mk96.extensible.api.crud.domain.service.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkExampleFindService<DOM extends MkDomain>
	extends MkService<DOM> {

	DOM find(DOM dom);

}