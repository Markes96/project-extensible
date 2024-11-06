package org.mk96.extensible.api.crud.application.save.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.all.MkSaveAllPort;
import org.mk96.extensible.api.crud.domain.service.save.all.MkSaveAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkSaveAllUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkSaveAllService<DOM> {

	@Delegate
	@Autowired
	private MkSaveAllPort<DOM> port;
	
}
