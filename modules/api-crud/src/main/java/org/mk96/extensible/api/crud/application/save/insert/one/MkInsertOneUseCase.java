package org.mk96.extensible.api.crud.application.save.insert.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.insert.one.MkInsertOnePort;
import org.mk96.extensible.api.crud.domain.service.save.insert.one.MkInsertOneService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkInsertOneUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkInsertOneService<DOM> {

	@Delegate
	@Autowired
	private MkInsertOnePort<DOM> port;
	
}
