package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter;

import org.mk96.extensible.api.crud.domain.service.delete.filter.MkDeleteByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.MkDeleteByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.all.MkDeleteAllByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.many.MkDeleteManyByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.one.MkDeleteOneByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.all.MkDeleteAllByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.many.MkDeleteManyByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.delete.filter.one.MkDeleteOneByFilterControllerImpl;
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
public class MkDeleteByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
	extends AbstractMkRestController<BOD, DOM, RES>
    implements MkDeleteByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkDeleteByFilterService<DOM> service;

    public MkDeleteByFilterControllerImpl(
            MkDeleteByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_delete_filter_controller();
    }

    @Delegate
    private MkDeleteOneByFilterController<BOD, RES> deleteOneByFilter;

    @Delegate
    private MkDeleteManyByFilterController<BOD, RES> deleteManyByFilter;

    @Delegate
    private MkDeleteAllByFilterController<BOD, RES> deleteAllByFilter;

    @PostConstruct
    void init_delete_filter_controller() {
        deleteOneByFilter = new MkDeleteOneByFilterControllerImpl<>(service, mapper);
        deleteManyByFilter = new MkDeleteManyByFilterControllerImpl<>(service, mapper);
        deleteAllByFilter = new MkDeleteAllByFilterControllerImpl<>(service, mapper);
    }

}
