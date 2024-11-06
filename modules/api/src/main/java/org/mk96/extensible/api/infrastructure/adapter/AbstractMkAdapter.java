package org.mk96.extensible.api.infrastructure.adapter;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;
import org.mk96.extensible.api.type.AbstractMkBean;

public abstract class AbstractMkAdapter<DOM extends MkDomain> 
	extends AbstractMkBean
	implements MkPort<DOM> {}
