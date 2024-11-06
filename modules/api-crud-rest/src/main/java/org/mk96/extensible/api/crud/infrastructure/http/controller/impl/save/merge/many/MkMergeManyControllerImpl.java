package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.many;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.save.merge.many.MkMergeManyService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.many.MkMergeManyController;
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
public class MkMergeManyControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkMergeManyController<BOD, RES> {

    @Autowired(required = false)
    private MkMergeManyService<DOM> service;

    public MkMergeManyControllerImpl(
            MkMergeManyService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/merge/many")
    public List<RES> mergeMany(@RequestBody MkMergeSave<BOD> reqMerge) {
        MkMergeSave<DOM> domMerge = reqMerge.map(mapper::map);
        List<DOM> domResponses = service.mergeMany(domMerge);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
