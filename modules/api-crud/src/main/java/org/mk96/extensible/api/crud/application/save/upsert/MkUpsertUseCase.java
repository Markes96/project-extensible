package org.mk96.extensible.api.crud.application.save.upsert;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.upsert.MkUpsertPort;
import org.mk96.extensible.api.crud.domain.service.save.upsert.MkUpsertService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkUpsertUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkUpsertService<DOM> {

	@Delegate
	@Autowired
	private MkUpsertPort<DOM> port;
	
}
