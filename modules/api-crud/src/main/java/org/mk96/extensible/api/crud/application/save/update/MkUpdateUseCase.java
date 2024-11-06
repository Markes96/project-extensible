package org.mk96.extensible.api.crud.application.save.update;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.update.MkUpdatePort;
import org.mk96.extensible.api.crud.domain.service.save.update.MkUpdateService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpdateUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpdateService<DOM> {
	
	@Delegate
	@Autowired
	private MkUpdatePort<DOM> port;
	
}
