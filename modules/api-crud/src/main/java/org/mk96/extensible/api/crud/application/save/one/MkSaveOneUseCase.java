package org.mk96.extensible.api.crud.application.save.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.one.MkSaveOnePort;
import org.mk96.extensible.api.crud.domain.service.save.one.MkSaveOneService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkSaveOneUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkSaveOneService<DOM> {

	@Delegate
	@Autowired
	private MkSaveOnePort<DOM> port;
	
}
