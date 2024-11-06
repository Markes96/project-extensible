package org.mk96.extensible.api.crud.infrastructure.http.id.type;

import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdCreateController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkTypeIdCreateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkIdCreateController<REQ, DOM, RES, ID> {

	@Override
	@PutMapping("/create/{id}")
	RES create(@PathVariable("id") ID id, @RequestBody REQ body);

}
