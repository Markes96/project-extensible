package org.mk96.extensible.api.infrastructure.http.controller.body;

import org.mk96.extensible.api.infrastructure.http.controller.base.MkBaseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;

public interface MkBodyRestController<BOD extends MkRestBodyDto>
    extends MkBaseRestController {}