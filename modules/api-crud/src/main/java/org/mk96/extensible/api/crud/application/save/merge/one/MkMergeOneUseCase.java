package org.mk96.extensible.api.crud.application.save.merge.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.merge.one.MkMergeOnePort;
import org.mk96.extensible.api.crud.domain.service.save.merge.one.MkMergeOneService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkMergeOneUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkMergeOneService<DOM> {

	@Delegate
	@Autowired
	private MkMergeOnePort<DOM> port;
	
}
