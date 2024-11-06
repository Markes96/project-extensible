package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id.all;

import java.util.List;
import org.mk96.extensible.api.crud.domain.service.delete.id.all.MkDeleteAllByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.all.MkDeleteAllByIdController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.impl.AbstractMkBaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkDeleteAllByIdControllerImpl<DOM extends MkDomain, ID>
    extends AbstractMkBaseRestController<DOM>
    implements MkDeleteAllByIdController<ID> {

    @Autowired(required = false)
    private MkDeleteAllByIdService<DOM, ID> service;

    public MkDeleteAllByIdControllerImpl(MkDeleteAllByIdService<DOM, ID> service) {
        this.service = service;
    }

    @Override
    @DeleteMapping("/delete/all/id")
    public void deleteAllById(@RequestBody List<ID> ids) {
        service.deleteAllById(ids);
    }

}
