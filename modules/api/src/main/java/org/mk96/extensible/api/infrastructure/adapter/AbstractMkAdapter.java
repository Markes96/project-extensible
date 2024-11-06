package org.mk96.extensible.api.infrastructure.adapter;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public abstract class AbstractMkAdapter<DOM extends MkDomain> implements MkPort<DOM> {}
