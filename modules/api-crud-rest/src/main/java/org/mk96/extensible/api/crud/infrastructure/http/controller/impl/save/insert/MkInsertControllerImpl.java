package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert;

import org.mk96.extensible.api.crud.domain.service.save.insert.MkInsertService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert.all.MkInsertAllControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert.one.MkInsertOneControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.MkInsertController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.all.MkInsertAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.one.MkInsertOneController;
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
public class MkInsertControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkInsertController<BOD, RES> {

    @Autowired(required = false)
    private MkInsertService<DOM> service;

    public MkInsertControllerImpl(
            MkInsertService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_insert_controller();
    }

    @Delegate
    private MkInsertOneController<BOD, RES> insertOne;

    @Delegate
    private MkInsertAllController<BOD, RES> insertAll;

    @PostConstruct
    void init_insert_controller() {
        insertOne = new MkInsertOneControllerImpl<>(service, mapper);
        insertAll = new MkInsertAllControllerImpl<>(service, mapper);
    }

}
