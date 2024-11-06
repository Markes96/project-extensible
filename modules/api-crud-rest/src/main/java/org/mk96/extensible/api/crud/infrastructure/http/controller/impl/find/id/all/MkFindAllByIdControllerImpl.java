package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id.all;

import java.util.List;
import org.mk96.common.util.MkMapUtils;
import org.mk96.extensible.api.crud.domain.service.find.id.all.MkFindAllByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.all.MkFindAllByIdController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.response.impl.AbstractMkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkFindAllByIdControllerImpl<DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkFindAllByIdController<RES, ID> {

    @Autowired(required = false)
    private MkFindAllByIdService<DOM, ID> service;

    public MkFindAllByIdControllerImpl(
            MkFindAllByIdService<DOM, ID> service,
            MkRestResponseMapper<DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/all/id")
    public List<RES> findAllById(@RequestBody List<ID> ids) {
        List<DOM> domResponses = service.findAllById(ids);
        return MkMapUtils.mapList(domResponses, mapper::map);
    }

}
