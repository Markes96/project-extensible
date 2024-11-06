package org.mk96.extensible.api.crud.application.save.insert.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.domain.service.save.insert.all.MkInsertAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkInsertAllUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkInsertAllService<DOM> {

	@Delegate
	@Autowired
	private MkInsertAllPort<DOM> port;
	
}
