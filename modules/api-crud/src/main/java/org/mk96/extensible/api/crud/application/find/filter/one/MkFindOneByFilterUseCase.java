package org.mk96.extensible.api.crud.application.find.filter.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.filter.one.MkFindOneByFilterPort;
import org.mk96.extensible.api.crud.domain.service.find.filter.one.MkFindOneByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindOneByFilterUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkFindOneByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkFindOneByFilterPort<DOM> port;
	
}
