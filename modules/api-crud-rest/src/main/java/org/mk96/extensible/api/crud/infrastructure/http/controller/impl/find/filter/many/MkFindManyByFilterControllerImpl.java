package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.many;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.find.filter.many.MkFindManyByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.many.MkFindManyByFilterController;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkFindManyByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindManyByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkFindManyByFilterService<DOM> service;

    public MkFindManyByFilterControllerImpl(
            MkFindManyByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/many/filter")
    public List<RES> findManyByFilter(@RequestBody MkFilter<BOD> reqFilter) {
        MkFilter<DOM> domFilter = reqFilter.map(mapper::map);
        List<DOM> domResponses = service.findMany(domFilter);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
