package org.mk96.extensible.api.crud.application.find.id;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.id.MkFindByIdPort;
import org.mk96.extensible.api.crud.domain.service.find.id.MkFindByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindByIdUseCase<DOM extends MkDomain, ID> 
	extends AbstractMkUseCase<DOM>
	implements MkFindByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkFindByIdPort<DOM, ID> port;

}
