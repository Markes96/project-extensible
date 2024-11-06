package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert.one;

import org.mk96.extensible.api.crud.domain.service.save.insert.one.MkInsertOneService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.one.MkInsertOneController;
import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
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
public class MkInsertOneControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkInsertOneController<BOD, RES> {

    @Autowired(required = false)
    private MkInsertOneService<DOM> service;

    public MkInsertOneControllerImpl(
            MkInsertOneService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/insert/one")
    public RES insertOne(@RequestBody MkInsertSave<BOD> reqInsert) {
        MkInsertSave<DOM> domInsert = reqInsert.map(mapper::map);
        DOM domResponse = service.insertOne(domInsert);
        return mapper.map(domResponse);
    }

}
