package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.many;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.delete.filter.many.MkDeleteManyByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.many.MkDeleteManyByFilterController;
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
public class MkDeleteManyByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkDeleteManyByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkDeleteManyByFilterService<DOM> service;

    public MkDeleteManyByFilterControllerImpl(
            MkDeleteManyByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @DeleteMapping("/delete/many/filter")
    public List<RES> deleteManyByFilter(@RequestBody MkFilter<BOD> reqFilter) {
        MkFilter<DOM> domFilter = reqFilter.map(mapper::map);
        List<DOM> domResponses = service.deleteMany(domFilter);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
