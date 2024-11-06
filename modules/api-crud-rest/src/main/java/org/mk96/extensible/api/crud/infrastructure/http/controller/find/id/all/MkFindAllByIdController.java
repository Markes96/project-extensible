package org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.all;

import java.util.List;
import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkFindAllByIdController<RES extends MkRestResponseDto, ID>
    extends MkResponseRestController<RES> {

    @PostMapping("/find/all/id")
    List<RES> findAllById(@RequestBody List<ID> ids);

}
