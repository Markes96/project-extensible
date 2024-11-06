package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save;

import org.mk96.extensible.api.crud.domain.service.save.MkSaveService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert.MkInsertControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.MkMergeControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update.MkUpdateControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert.MkUpsertControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.MkSaveController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.MkInsertController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.MkMergeController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.MkUpdateController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.MkUpsertController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkSaveControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkSaveController<BOD, RES> {

    @Autowired(required = false)
    private MkSaveService<DOM> service;

    public MkSaveControllerImpl(
            MkSaveService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_save_controller();
    }

    @Delegate
    private MkInsertController<BOD, RES> insert;

    @Delegate
    private MkMergeController<BOD, RES> merge;

    @Delegate
    private MkUpdateController<BOD, RES> update;

    @Delegate
    private MkUpsertController<BOD, RES> upsert;

    @PostConstruct
    void init_save_controller() {
        insert = new MkInsertControllerImpl<>(service, mapper);
        merge = new MkMergeControllerImpl<>(service, mapper);
        update = new MkUpdateControllerImpl<>(service, mapper);
        upsert = new MkUpsertControllerImpl<>(service, mapper);
    }

}
