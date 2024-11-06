package org.mk96.extensible.api.infrastructure.http.controller.response;

import org.mk96.extensible.api.infrastructure.http.controller.base.MkBaseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkResponseRestController<RES extends MkRestResponseDto>
    extends MkBaseRestController {}