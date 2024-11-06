package org.mk96.extensible.api.infrastructure.http.controller;

import org.mk96.extensible.api.infrastructure.http.controller.body.MkBodyRestController;
import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;

public interface MkRestController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
    extends MkBodyRestController<BOD>, MkResponseRestController<RES> {}
