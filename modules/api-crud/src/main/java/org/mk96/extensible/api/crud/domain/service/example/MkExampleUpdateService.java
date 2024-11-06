package org.mk96.extensible.api.crud.domain.service.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkExampleUpdateService<DOM extends MkDomain>
	extends MkService<DOM> {

	DOM update(DOM dom);

}