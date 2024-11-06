package org.mk96.extensible.api.crud.application.find.id.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.id.one.MkFindOneByIdPort;
import org.mk96.extensible.api.crud.domain.service.find.id.one.MkFindOneByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindOneByIdUseCase<DOM extends MkDomain, ID> 
	extends AbstractMkUseCase<DOM>
	implements MkFindOneByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkFindOneByIdPort<DOM, ID> port;

}
