package org.mk96.extensible.api.crud.infrastructure.http.delete;

import java.util.List;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.MkController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkJpaDeleteByIdController<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto, ID>
	extends MkController<REQ, DOM, RES> {
	
	@DeleteMapping("/delete/id")
	public void deleteById(@RequestBody ID id);

	@DeleteMapping("/delete/id/all")
	public void deleteAllById(@RequestBody List<ID> ids);


}
