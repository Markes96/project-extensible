package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert;

import org.mk96.extensible.api.crud.domain.service.save.upsert.MkUpsertService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert.all.MkUpsertAllControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert.one.MkUpsertOneControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.MkUpsertController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.all.MkUpsertAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.one.MkUpsertOneController;
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
public class MkUpsertControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpsertController<BOD, RES> {

    @Autowired(required = false)
    private MkUpsertService<DOM> service;

    public MkUpsertControllerImpl(
            MkUpsertService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_upsert_controller();
    }

    @Delegate
    private MkUpsertOneController<BOD, RES> upsertOne;

    @Delegate
    private MkUpsertAllController<BOD, RES> upsertAll;

    @PostConstruct
    void init_upsert_controller() {
        upsertOne = new MkUpsertOneControllerImpl<>(service, mapper);
        upsertAll = new MkUpsertAllControllerImpl<>(service, mapper);
    }

}
