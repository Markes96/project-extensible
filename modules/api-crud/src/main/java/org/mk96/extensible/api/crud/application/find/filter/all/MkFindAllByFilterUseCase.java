package org.mk96.extensible.api.crud.application.find.filter.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.filter.all.MkFindAllByFilterPort;
import org.mk96.extensible.api.crud.domain.service.find.filter.all.MkFindAllByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.Delegate;

public class MkFindAllByFilterUseCase<DOM extends MkDomain> 
	extends AbstractMkUseCase<DOM>
	implements MkFindAllByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkFindAllByFilterPort<DOM> port;
	
}
