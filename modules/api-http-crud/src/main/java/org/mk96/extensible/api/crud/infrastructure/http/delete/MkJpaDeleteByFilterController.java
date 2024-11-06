package org.mk96.extensible.api.crud.infrastructure.http.delete;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.MkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MkJpaDeleteByFilterController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	extends MkController<REQ, DOM, RES> {

	@DeleteMapping("/delete")
	public void delete(
	        @RequestBody REQ id, 
	        @RequestParam(required = false) String filterType);

	@DeleteMapping("/delete/all")
	public void deleteAll(
	        @RequestBody List<REQ> ids, 
	        @RequestParam(required = false) String filterType);

}
