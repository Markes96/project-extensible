package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.all;

import java.util.List;
import org.mk96.extensible.api.infrastructure.http.controller.base.MkBaseRestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkDeleteAllByIdController<ID>
    extends MkBaseRestController {

    @DeleteMapping("/delete/all/id")
	void deleteAllById(@RequestBody List<ID> ids);

}
