package org.mk96.extensible.api.crud.application.save.update.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.update.all.MkUpdateAllPort;
import org.mk96.extensible.api.crud.domain.service.save.update.all.MkUpdateAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpdateAllUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpdateAllService<DOM> {
	
	@Delegate
	@Autowired
	private MkUpdateAllPort<DOM> port;
	
}
