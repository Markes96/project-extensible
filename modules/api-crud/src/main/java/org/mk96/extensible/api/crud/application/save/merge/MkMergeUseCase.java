package org.mk96.extensible.api.crud.application.save.merge;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.merge.MkMergePort;
import org.mk96.extensible.api.crud.domain.service.save.merge.MkMergeService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkMergeUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkMergeService<DOM> {

	@Delegate
	@Autowired
	private MkMergePort<DOM> port;
	
}
