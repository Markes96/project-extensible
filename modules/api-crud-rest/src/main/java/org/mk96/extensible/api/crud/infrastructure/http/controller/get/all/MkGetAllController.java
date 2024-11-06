package org.mk96.extensible.api.crud.infrastructure.http.controller.get.all;

import java.util.List;

import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;

public interface MkGetAllController<RES extends MkRestResponseDto>
    extends MkResponseRestController<RES> {

    @GetMapping("/get/all")
    List<RES> getAll();

}
