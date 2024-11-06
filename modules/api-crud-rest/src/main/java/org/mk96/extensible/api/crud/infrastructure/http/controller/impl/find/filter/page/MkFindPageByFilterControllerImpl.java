package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.page;

import java.util.List;

import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.find.filter.page.MkFindPageByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.page.MkFindPageByFilterController;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkFindPageByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindPageByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkFindPageByFilterService<DOM> service;

    public MkFindPageByFilterControllerImpl(
            MkFindPageByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/page/filter")
    public List<RES> findPageByFilter(@RequestBody MkFilter<BOD> reqFilter, Pageable pageable) {
        MkFilter<DOM> domFilter = reqFilter.map(mapper::map);
        List<DOM> domResponses = service.findPageByFilter(domFilter, pageable);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
