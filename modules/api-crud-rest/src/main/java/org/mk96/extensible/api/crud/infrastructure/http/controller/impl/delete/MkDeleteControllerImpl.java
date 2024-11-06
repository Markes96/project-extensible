package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete;

import org.mk96.extensible.api.crud.domain.service.delete.MkDeleteService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.MkDeleteController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.MkDeleteByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.id.MkDeleteByIdController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.MkDeleteByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.id.MkDeleteByIdControllerImpl;
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
public class MkDeleteControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkDeleteController<BOD, RES, ID> {

    @Autowired(required = false)
    private MkDeleteService<DOM, ID> service;

    public MkDeleteControllerImpl(
            MkDeleteService<DOM, ID> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_delete_controller();
    }

    @Delegate
    private MkDeleteByIdController<ID> deleteById;

    @Delegate
    private MkDeleteByFilterController<BOD, RES> deleteByFilter;

    @PostConstruct
    void init_delete_controller() {
        deleteById = new MkDeleteByIdControllerImpl<>(service);
        deleteByFilter = new MkDeleteByFilterControllerImpl<>(service, mapper);
    }

}
