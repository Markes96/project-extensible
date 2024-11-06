package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.one;

import org.mk96.extensible.api.crud.domain.service.save.merge.one.MkMergeOneService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.one.MkMergeOneController;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
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
public class MkMergeOneControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkMergeOneController<BOD, RES> {

    @Autowired(required = false)
    private MkMergeOneService<DOM> service;

    public MkMergeOneControllerImpl(
            MkMergeOneService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/merge/one")
    public RES mergeOne(@RequestBody MkMergeSave<BOD> reqMerge) {
        MkMergeSave<DOM> domMerge = reqMerge.map(mapper::map);
        DOM domResponse = service.mergeOne(domMerge);
        return mapper.map(domResponse);
    }

}
