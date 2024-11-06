package org.mk96.extensible.api.infrastructure.http.crud.example;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.MkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkExampleDeleteController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkController<REQ, DOM, RES> {

	@DeleteMapping("/delete")
	RES delete(@RequestBody REQ body);

}
