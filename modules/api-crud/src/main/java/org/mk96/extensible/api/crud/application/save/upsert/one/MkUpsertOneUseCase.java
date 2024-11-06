package org.mk96.extensible.api.crud.application.save.upsert.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.upsert.one.MkUpsertOnePort;
import org.mk96.extensible.api.crud.domain.service.save.upsert.one.MkUpsertOneService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpsertOneUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpsertOneService<DOM> {

	@Delegate
	@Autowired
	private MkUpsertOnePort<DOM> port;
	
}
