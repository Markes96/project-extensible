package org.mk96.extensible.api.crud.infrastructure.http.id.type;

import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdFindController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MkTypeIdFindController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkIdFindController<REQ, DOM, RES, ID> {

	@Override
	@GetMapping("/find/{id}")
	RES find(@PathVariable("id") ID id);

}
