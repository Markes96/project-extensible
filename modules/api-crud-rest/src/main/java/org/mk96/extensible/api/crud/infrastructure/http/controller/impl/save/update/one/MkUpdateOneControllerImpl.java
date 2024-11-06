package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update.one;

import org.mk96.extensible.api.crud.domain.service.save.update.one.MkUpdateOneService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.one.MkUpdateOneController;
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
public class MkUpdateOneControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpdateOneController<BOD, RES> {

    @Autowired(required = false)
    private MkUpdateOneService<DOM> service;

    public MkUpdateOneControllerImpl(
            MkUpdateOneService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/update/one")
    public RES updateOne(@RequestBody MkUpdateSave<BOD> reqUpdate) {
        MkUpdateSave<DOM> domUpdate = reqUpdate.map(mapper::map);
        DOM domResponse = service.updateOne(domUpdate);
        return mapper.map(domResponse);
    }

}
