package org.mk96.extensible.api.crud.infrastructure.http.controller.impl;

import org.mk96.extensible.api.crud.domain.service.MkCrudService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.MkCrudController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.MkDeleteController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.MkFindController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.MkGetController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.MkDeleteControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.MkFindControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get.MkGetControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.MkSaveControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.MkSaveController;
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
public class MkCrudControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkCrudController<BOD, RES, ID> {

    @Autowired(required = false)
    private MkCrudService<DOM, ID> service;

    public MkCrudControllerImpl(
            MkCrudService<DOM, ID> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_crud_controller();
    }
    
    @Delegate
    private MkGetController<RES> get;

    @Delegate
    private MkFindController<BOD, RES, ID> find;

    @Delegate
    private MkSaveController<BOD, RES> save;

    @Delegate
    private MkDeleteController<BOD, RES, ID> delete;

    @PostConstruct
    void init_crud_controller() {
    	get = new MkGetControllerImpl<>(service, mapper);
        find = new MkFindControllerImpl<>(service, mapper);
        save = new MkSaveControllerImpl<>(service, mapper);
        delete = new MkDeleteControllerImpl<>(service, mapper);
    }

}
