package org.mk96.extensible.api.crud.application.find.filter.many;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.filter.many.MkFindManyByFilterPort;
import org.mk96.extensible.api.crud.domain.service.find.filter.many.MkFindManyByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindManyByFilterUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkFindManyByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkFindManyByFilterPort<DOM> port;
	
}
