package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.save.update.all.MkUpdateAllService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.all.MkUpdateAllController;
import org.mk96.extensible.api.crud.type.save.safe.update.MkUpdateSave;
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
public class MkUpdateAllControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpdateAllController<BOD, RES> {

    @Autowired(required = false)
    private MkUpdateAllService<DOM> service;

    public MkUpdateAllControllerImpl(
            MkUpdateAllService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/update/all")
    public List<RES> updateAll(@RequestBody List<MkUpdateSave<BOD>> domUpdates) {
        List<MkUpdateSave<DOM>> domFilters = MkMapUtils.mapList(domUpdates, update -> update.map(mapper::map));
        List<DOM> domResponses = service.updateAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
