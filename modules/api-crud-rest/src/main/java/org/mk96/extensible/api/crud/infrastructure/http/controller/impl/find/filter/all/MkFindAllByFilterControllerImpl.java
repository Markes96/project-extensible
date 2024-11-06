package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.find.filter.all.MkFindAllByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.all.MkFindAllByFilterController;
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
public class MkFindAllByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindAllByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkFindAllByFilterService<DOM> service;

    public MkFindAllByFilterControllerImpl(
            MkFindAllByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/all/filter")
    public List<RES> findAllByFilter(@RequestBody List<MkFilter<BOD>> reqFilters) {
        List<MkFilter<DOM>> domFilters = MkMapUtils.mapList(reqFilters, MkFilter.transform(mapper::map));
        List<DOM> domResponses = service.findAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
