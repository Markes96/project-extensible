package org.mk96.extensible.api.infrastructure.http.controller.body.impl;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.impl.AbstractMkBaseRestController;
import org.mk96.extensible.api.infrastructure.http.controller.body.MkBodyRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.mapper.body.MkRestBodyMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMkBodyRestController<BOD extends MkRestBodyDto, DOM extends MkDomain>
    extends AbstractMkBaseRestController<DOM>
    implements MkBodyRestController<BOD> {

	@Autowired(required = false)
	protected MkRestBodyMapper<BOD, DOM> mapper;

}
