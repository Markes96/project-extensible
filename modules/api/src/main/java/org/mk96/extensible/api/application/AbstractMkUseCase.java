package org.mk96.extensible.api.application;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;
import org.mk96.extensible.api.type.AbstractMkBean;

public abstract class AbstractMkUseCase<DOM extends MkDomain> 
	extends AbstractMkBean
	implements MkService<DOM> {}
