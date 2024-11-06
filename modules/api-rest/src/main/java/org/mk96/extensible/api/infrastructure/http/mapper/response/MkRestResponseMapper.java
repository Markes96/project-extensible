package org.mk96.extensible.api.infrastructure.http.mapper.response;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkRestResponseMapper<DOM extends MkDomain, RES extends MkRestResponseDto> {

	RES map(DOM domain);

}
