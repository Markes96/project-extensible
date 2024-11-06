package org.mk96.extensible.api.infrastructure.http.crud.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.MkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkExampleUpdateController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkController<REQ, DOM, RES> {

	@PutMapping("/update")
	RES update(@RequestBody REQ body);

}
