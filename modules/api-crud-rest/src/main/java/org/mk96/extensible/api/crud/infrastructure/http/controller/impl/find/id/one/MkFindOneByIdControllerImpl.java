package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id.one;

import org.mk96.extensible.api.crud.domain.service.find.id.one.MkFindOneByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.one.MkFindOneByIdController;
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
public class MkFindOneByIdControllerImpl<DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkFindOneByIdController<RES, ID> {

    @Autowired(required = false)
    private MkFindOneByIdService<DOM, ID> service;

    public MkFindOneByIdControllerImpl(
            MkFindOneByIdService<DOM, ID> service,
            MkRestResponseMapper<DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @PostMapping("/find/one/id")
    public RES findOneById(@RequestBody ID id) {
        DOM domResponse = service.findOneById(id);
        return mapper.map(domResponse);
    }

}
