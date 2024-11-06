package org.mk96.extensible.api.application;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public abstract class AbstractMkUseCase<DOM extends MkDomain> implements MkService<DOM> {}
