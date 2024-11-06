package org.mk96.extensible.api.crud.infrastructure.http.controller.get.page;

import java.util.List;

import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

public interface MkGetPageController<RES extends MkRestResponseDto>
    extends MkResponseRestController<RES> {

    @GetMapping("/get/page")
    List<RES> getPage(Pageable pageable);

}
