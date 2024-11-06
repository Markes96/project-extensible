package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.upsert.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.save.upsert.all.MkUpsertAllService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.all.MkUpsertAllController;
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
public class MkUpsertAllControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpsertAllController<BOD, RES> {

    @Autowired(required = false)
    private MkUpsertAllService<DOM> service;

    public MkUpsertAllControllerImpl(
            MkUpsertAllService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/upsert/all")
    public List<RES> upsertAll(@RequestBody List<MkUpsertSave<BOD>> domUpserts) {
        List<MkUpsertSave<DOM>> domFilters = MkMapUtils.mapList(domUpserts, upsert -> upsert.map(mapper::map));
        List<DOM> domResponses = service.upsertAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
