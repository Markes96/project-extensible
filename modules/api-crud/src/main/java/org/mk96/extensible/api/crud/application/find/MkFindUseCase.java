package org.mk96.extensible.api.crud.application.find;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.MkFindPort;
import org.mk96.extensible.api.crud.domain.service.find.MkFindService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindUseCase<DOM extends MkDomain, ID> 
	extends AbstractMkUseCase<DOM>
	implements MkFindService<DOM, ID> {

	@Delegate
	@Autowired
	private MkFindPort<DOM, ID> port;

}
