package org.mk96.extensible.api.crud.application.find.id.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.id.all.MkFindAllByIdPort;
import org.mk96.extensible.api.crud.domain.service.find.id.all.MkFindAllByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindAllByIdUseCase<DOM extends MkDomain, ID> 
	extends AbstractMkUseCase<DOM>
	implements MkFindAllByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkFindAllByIdPort<DOM, ID> port;

}
