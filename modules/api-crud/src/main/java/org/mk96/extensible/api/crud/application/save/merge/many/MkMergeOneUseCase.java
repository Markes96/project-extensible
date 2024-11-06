package org.mk96.extensible.api.crud.application.save.merge.many;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.save.merge.many.MkMergeManyPort;
import org.mk96.extensible.api.crud.domain.service.save.merge.many.MkMergeManyService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.experimental.Delegate;

public class MkMergeOneUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkMergeManyService<DOM> {

	@Delegate
	@Autowired(required = false)
	private MkMergeManyPort<DOM> port;

}
