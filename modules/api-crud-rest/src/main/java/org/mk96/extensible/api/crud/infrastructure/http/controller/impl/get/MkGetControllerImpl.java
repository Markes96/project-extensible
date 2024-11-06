package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get;

import org.mk96.extensible.api.crud.domain.service.get.MkGetService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.MkGetController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.all.MkGetAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.page.MkGetPageController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get.all.MkGetAllControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get.page.MkGetPageControllerImpl;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.response.impl.AbstractMkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkGetControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkGetController<RES> {

    @Autowired(required = false)
    private MkGetService<DOM> service;

    public MkGetControllerImpl(
    		MkGetService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_get_controller();
    }

    @Delegate
    private MkGetAllController<RES> getAll;

    @Delegate
    private MkGetPageController<RES> getPage;

    @PostConstruct
    void init_get_controller() {
    	getAll = new MkGetAllControllerImpl<>(service, mapper);
    	getPage = new MkGetPageControllerImpl<>(service, mapper);
    }

}
