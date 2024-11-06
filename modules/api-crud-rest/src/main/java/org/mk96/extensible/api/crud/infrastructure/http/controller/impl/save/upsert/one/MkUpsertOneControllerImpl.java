package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert.one;

import org.mk96.extensible.api.crud.domain.service.save.upsert.one.MkUpsertOneService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.one.MkUpsertOneController;
import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkUpsertOneControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpsertOneController<BOD, RES> {

    @Autowired(required = false)
    private MkUpsertOneService<DOM> service;

    public MkUpsertOneControllerImpl(
            MkUpsertOneService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/upsert/one")
    public RES upsertOne(@RequestBody MkUpsertSave<BOD> reqUpsert) {
        MkUpsertSave<DOM> domUpsert = reqUpsert.map(mapper::map);
        DOM domResponse = service.upsertOne(domUpsert);
        return mapper.map(domResponse);
    }

}
