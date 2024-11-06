package org.mk96.extensible.api.crud.application.save.update.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.update.one.MkUpdateOnePort;
import org.mk96.extensible.api.crud.domain.service.save.update.one.MkUpdateOneService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpdateOneUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpdateOneService<DOM> {
	
	@Delegate
	@Autowired
	private MkUpdateOnePort<DOM> port;
	
}
