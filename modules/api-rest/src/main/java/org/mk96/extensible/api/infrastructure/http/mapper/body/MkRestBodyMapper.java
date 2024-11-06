package org.mk96.extensible.api.infrastructure.http.mapper.body;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;

public interface MkRestBodyMapper<BOD extends MkRestBodyDto, DOM extends MkDomain> {

    DOM map(BOD body);

}