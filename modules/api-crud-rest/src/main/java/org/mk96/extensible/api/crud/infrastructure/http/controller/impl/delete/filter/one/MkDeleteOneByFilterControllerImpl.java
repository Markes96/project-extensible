package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.one;

import org.mk96.extensible.api.crud.domain.service.delete.filter.one.MkDeleteOneByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.one.MkDeleteOneByFilterController;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkDeleteOneByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkDeleteOneByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkDeleteOneByFilterService<DOM> service;

    public MkDeleteOneByFilterControllerImpl(
            MkDeleteOneByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @DeleteMapping("/delete/one/filter")
    public RES deleteOneByFilter(@RequestBody MkFilter<BOD> reqFilter) {
        MkFilter<DOM> domFilter = reqFilter.map(mapper::map);
        DOM domResponse = service.deleteOne(domFilter);
        return mapper.map(domResponse);
    }

}
