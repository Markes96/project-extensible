package org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.one;

import org.mk96.extensible.api.infrastructure.http.controller.response.MkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkFindOneByIdController<RES extends MkRestResponseDto, ID>
    extends MkResponseRestController<RES> {

    @PostMapping("/find/one/id")
    RES findOneById(@RequestBody ID id);

}
