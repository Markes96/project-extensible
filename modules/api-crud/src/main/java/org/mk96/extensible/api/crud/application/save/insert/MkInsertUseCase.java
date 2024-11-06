package org.mk96.extensible.api.crud.application.save.insert;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.insert.MkInsertPort;
import org.mk96.extensible.api.crud.domain.service.save.insert.MkInsertService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkInsertUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkInsertService<DOM> {

	@Delegate
	@Autowired
	private MkInsertPort<DOM> port;
	
}
