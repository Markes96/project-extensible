package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.one;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkDeleteOneByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
    extends MkRestController<BOD, RES> {

    @DeleteMapping("/delete/one/filter")
    RES deleteOneByFilter(@RequestBody MkFilter<BOD> filter);

}
