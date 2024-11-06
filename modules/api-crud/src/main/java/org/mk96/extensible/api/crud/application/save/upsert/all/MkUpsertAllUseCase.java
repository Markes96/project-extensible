package org.mk96.extensible.api.crud.application.save.upsert.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.upsert.all.MkUpsertAllPort;
import org.mk96.extensible.api.crud.domain.service.save.upsert.all.MkUpsertAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpsertAllUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpsertAllService<DOM> {

	@Delegate
	@Autowired
	private MkUpsertAllPort<DOM> port;
	
}
