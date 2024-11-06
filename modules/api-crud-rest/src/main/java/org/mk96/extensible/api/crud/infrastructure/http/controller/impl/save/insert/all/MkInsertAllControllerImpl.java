package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.insert.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.save.insert.all.MkInsertAllService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.insert.all.MkInsertAllController;
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
public class MkInsertAllControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkInsertAllController<BOD, RES> {

    @Autowired(required = false)
    private MkInsertAllService<DOM> service;

    public MkInsertAllControllerImpl(
            MkInsertAllService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/insert/all")
    public List<RES> insertAll(@RequestBody List<MkInsertSave<BOD>> domInserts) {
        List<MkInsertSave<DOM>> domFilters = MkMapUtils.mapList(domInserts, insert -> insert.map(mapper::map));
        List<DOM> domResponses = service.insertAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
