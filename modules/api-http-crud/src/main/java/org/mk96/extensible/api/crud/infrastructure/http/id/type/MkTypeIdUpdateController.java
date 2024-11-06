package org.mk96.extensible.api.crud.infrastructure.http.id.type;

import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdUpdateController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkTypeIdUpdateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkIdUpdateController<REQ, DOM, RES, ID> {

	@Override
	@PutMapping("/update/{id}")
	RES update(@PathVariable("id") ID id, @RequestBody REQ body);

}
