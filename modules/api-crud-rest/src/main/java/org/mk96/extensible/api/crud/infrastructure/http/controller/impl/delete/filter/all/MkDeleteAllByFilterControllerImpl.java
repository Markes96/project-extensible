package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.delete.filter.all.MkDeleteAllByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.all.MkDeleteAllByFilterController;
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
public class MkDeleteAllByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkDeleteAllByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkDeleteAllByFilterService<DOM> service;

    public MkDeleteAllByFilterControllerImpl(
            MkDeleteAllByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @DeleteMapping("/delete/all/filter")
    public List<RES> deleteAllByFilter(@RequestBody List<MkFilter<BOD>> reqFilters) {
        List<MkFilter<DOM>> domFilters = MkMapUtils.mapList(reqFilters, MkFilter.transform(mapper::map));
        List<DOM> domResponses = service.deleteAll(domFilters);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
