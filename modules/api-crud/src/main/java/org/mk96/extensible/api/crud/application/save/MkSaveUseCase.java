package org.mk96.extensible.api.crud.application.save;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.MkSavePort;
import org.mk96.extensible.api.crud.domain.service.save.MkSaveService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkSaveUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkSaveService<DOM> {

	@Delegate
	@Autowired
	private MkSavePort<DOM> port;
	
}
