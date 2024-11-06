package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.one;

import org.mk96.extensible.api.crud.domain.service.find.filter.one.MkFindOneByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.one.MkFindOneByFilterController;
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
public class MkFindOneByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindOneByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkFindOneByFilterService<DOM> service;

    public MkFindOneByFilterControllerImpl(
            MkFindOneByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/one/filter")
    public RES findOneByFilter(@RequestBody MkFilter<BOD> reqFilter) {
        MkFilter<DOM> domFilter = reqFilter.map(mapper::map);
        DOM domResponse = service.findOne(domFilter);
        return mapper.map(domResponse);
    }

}
