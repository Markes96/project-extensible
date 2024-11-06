package org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.page;

import java.util.List;

import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkFindPageByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
    extends MkRestController<BOD, RES> {

    @PostMapping("/find/page/filter")
    List<RES> findPageByFilter(@RequestBody MkFilter<BOD> filter, Pageable pageable);

}
