package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter;

import org.mk96.extensible.api.crud.domain.service.find.filter.MkFindByFilterService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.MkFindByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.all.MkFindAllByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.many.MkFindManyByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.one.MkFindOneByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.page.MkFindPageByFilterController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.all.MkFindAllByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.many.MkFindManyByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.one.MkFindOneByFilterControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.find.filter.page.MkFindPageByFilterControllerImpl;
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
public class MkFindByFilterControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
	extends AbstractMkRestController<BOD, DOM, RES>
    implements MkFindByFilterController<BOD, RES> {

    @Autowired(required = false)
    private MkFindByFilterService<DOM> service;

    public MkFindByFilterControllerImpl(
            MkFindByFilterService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_find_filter_controller();
    }

    @Delegate
    private MkFindOneByFilterController<BOD, RES> findOneByFilter;

    @Delegate
    private MkFindManyByFilterController<BOD, RES> findManyByFilter;

    @Delegate
    private MkFindAllByFilterController<BOD, RES> findAllByFilter;

    @Delegate
    private MkFindPageByFilterController<BOD, RES> findPageByFilter;

    @PostConstruct
    void init_find_filter_controller() {
        findOneByFilter = new MkFindOneByFilterControllerImpl<>(service, mapper);
        findManyByFilter = new MkFindManyByFilterControllerImpl<>(service, mapper);
        findAllByFilter = new MkFindAllByFilterControllerImpl<>(service, mapper);
        findPageByFilter = new MkFindPageByFilterControllerImpl<>(service, mapper);
    }

}
