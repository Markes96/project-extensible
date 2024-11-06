package org.mk96.extensible.api.crud.infrastructure.http.id.type;

import org.mk96.extensible.api.crud.infrastructure.http.id.MkIdDeleteController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MkTypeIdDeleteController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkIdDeleteController<REQ, DOM, RES, ID> {

	@Override
	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable("id") ID id);

}
