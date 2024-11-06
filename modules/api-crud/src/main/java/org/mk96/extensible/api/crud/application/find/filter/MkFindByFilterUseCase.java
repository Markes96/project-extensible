package org.mk96.extensible.api.crud.application.find.filter;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.filter.MkFindByFilterPort;
import org.mk96.extensible.api.crud.domain.service.find.filter.MkFindByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindByFilterUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkFindByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkFindByFilterPort<DOM> port;
	
}
