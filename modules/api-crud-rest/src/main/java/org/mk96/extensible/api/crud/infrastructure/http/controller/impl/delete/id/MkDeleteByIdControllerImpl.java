package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id;

import org.mk96.extensible.api.crud.domain.service.delete.id.MkDeleteByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.MkDeleteByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.all.MkDeleteAllByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.one.MkDeleteOneByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id.all.MkDeleteAllByIdControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id.one.MkDeleteOneByIdControllerImpl;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.impl.AbstractMkBaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkDeleteByIdControllerImpl<DOM extends MkDomain, ID>
    extends AbstractMkBaseRestController<DOM>
    implements MkDeleteByIdController<ID> {

    @Autowired(required = false)
    private MkDeleteByIdService<DOM, ID> service;

    public MkDeleteByIdControllerImpl(MkDeleteByIdService<DOM, ID> service) {
        this.service = service;
        init_delete_id_controller();
    }

    @Delegate
    private MkDeleteOneByIdController<ID> deleteOneById;

    @Delegate
    private MkDeleteAllByIdController<ID> deleteAllById;

    @PostConstruct
    void init_delete_id_controller() {
        deleteOneById = new MkDeleteOneByIdControllerImpl<>(service);
        deleteAllById = new MkDeleteAllByIdControllerImpl<>(service);
    }

}
