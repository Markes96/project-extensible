package org.mk96.extensible.api.crud.application.save.merge.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.merge.all.MkMergeAllPort;
import org.mk96.extensible.api.crud.domain.service.save.merge.all.MkMergeAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkMergeAllUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkMergeAllService<DOM> {

	@Delegate
	@Autowired
	private MkMergeAllPort<DOM> port;
	
}
