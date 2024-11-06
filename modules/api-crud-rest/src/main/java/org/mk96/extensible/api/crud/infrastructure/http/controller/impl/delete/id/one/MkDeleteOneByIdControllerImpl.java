package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id.one;

import org.mk96.extensible.api.crud.domain.service.delete.id.one.MkDeleteOneByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.one.MkDeleteOneByIdController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.impl.AbstractMkBaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkDeleteOneByIdControllerImpl<DOM extends MkDomain, ID>
    extends AbstractMkBaseRestController<DOM>
    implements MkDeleteOneByIdController<ID> {

    @Autowired(required = false)
    private MkDeleteOneByIdService<DOM, ID> service;

    public MkDeleteOneByIdControllerImpl(MkDeleteOneByIdService<DOM, ID> service) {
        this.service = service;
    }

    @Override
    @DeleteMapping("/delete/one/id")
    public void deleteOneById(@RequestBody ID id) {
        service.deleteOneById(id);
    }

}
