package org.mk96.extensible.api.infrastructure.http.controller.response.impl;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.impl.AbstractMkBaseRestController;
import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMkResponseRestController<DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkBaseRestController<DOM>
    implements MkResponseRestController<RES> {

	@Autowired(required = false)
	protected MkRestResponseMapper<DOM, RES> mapper;

}
