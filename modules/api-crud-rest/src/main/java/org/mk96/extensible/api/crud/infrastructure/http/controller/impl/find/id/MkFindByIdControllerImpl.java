package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id;

import org.mk96.extensible.api.crud.domain.service.find.id.MkFindByIdService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.MkFindByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.all.MkFindAllByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.one.MkFindOneByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id.all.MkFindAllByIdControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id.one.MkFindOneByIdControllerImpl;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.response.impl.AbstractMkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkFindByIdControllerImpl<DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkFindByIdController<RES, ID> {

    @Autowired(required = false)
    private MkFindByIdService<DOM, ID> service;

    public MkFindByIdControllerImpl(
            MkFindByIdService<DOM, ID> service,
            MkRestResponseMapper<DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_find_id_controller();
    }

    @Delegate
    private MkFindOneByIdController<RES, ID> findOneById;

    @Delegate
    private MkFindAllByIdController<RES, ID> findAllById;

    @PostConstruct
    void init_find_id_controller() {
        findOneById = new MkFindOneByIdControllerImpl<>(service, mapper);
        findAllById = new MkFindAllByIdControllerImpl<>(service, mapper);
    }

}
