package org.mk96.extensible.api.infrastucture.http.controller.requitement.impl;

import org.mk96.extensible.api.infrastructure.http.AbstractMkController;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.DomainObject;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.RequestDto;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MkController
	extends AbstractMkController<RequestDto, DomainObject, ResponseDto> {}
