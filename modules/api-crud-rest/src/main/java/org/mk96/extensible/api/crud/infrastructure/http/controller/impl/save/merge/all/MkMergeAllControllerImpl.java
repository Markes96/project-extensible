package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.save.merge.all.MkMergeAllService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.all.MkMergeAllController;
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
public class MkMergeAllControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkMergeAllController<BOD, RES> {

    @Autowired(required = false)
    private MkMergeAllService<DOM> service;

    public MkMergeAllControllerImpl(
            MkMergeAllService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PutMapping("/intert/all")
    public List<RES> mergeAll(@RequestBody List<MkMergeSave<BOD>> domInserts) {
        List<MkMergeSave<DOM>> domFilters = MkMapUtils.mapList(domInserts, merge -> merge.map(mapper::map));
        List<DOM> domResponses = service.mergeAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
