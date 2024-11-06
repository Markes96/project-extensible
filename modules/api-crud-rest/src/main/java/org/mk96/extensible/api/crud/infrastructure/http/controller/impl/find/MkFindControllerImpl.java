package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find;

import org.mk96.extensible.api.crud.domain.service.find.MkFindService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.MkFindController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.MkFindByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.id.MkFindByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.MkFindByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.id.MkFindByIdControllerImpl;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.impl.AbstractMkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkFindControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindController<BOD, RES, ID> {

    @Autowired(required = false)
    private MkFindService<DOM, ID> service;

    public MkFindControllerImpl(
            MkFindService<DOM, ID> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_find_controller();
    }

    @Delegate
    private MkFindByIdController<RES, ID> findById;

    @Delegate
    private MkFindByFilterController<BOD, RES> findByFilter;

    @PostConstruct
    void init_find_controller() {
        findById = new MkFindByIdControllerImpl<>(service, mapper);
        findByFilter = new MkFindByFilterControllerImpl<>(service, mapper);
    }

}
