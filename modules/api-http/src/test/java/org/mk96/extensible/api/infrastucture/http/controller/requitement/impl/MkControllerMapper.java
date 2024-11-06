package org.mk96.extensible.api.infrastucture.http.controller.requitement.impl;

import org.mk96.extensible.api.infrastructure.http.mapper.impl.MkControllerModelMapper;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.DomainObject;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.RequestDto;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.type.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public final class MkControllerMapper
	extends MkControllerModelMapper<RequestDto, DomainObject, ResponseDto> {}
