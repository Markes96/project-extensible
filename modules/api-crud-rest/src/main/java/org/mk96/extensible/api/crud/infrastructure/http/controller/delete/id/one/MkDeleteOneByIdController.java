package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.one;

import org.mk96.extensible.api.infrastructure.http.controller.base.MkBaseRestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkDeleteOneByIdController<ID>
    extends MkBaseRestController {

    @DeleteMapping("/delete/one/id")
    void deleteOneById(@RequestBody ID id);

}
