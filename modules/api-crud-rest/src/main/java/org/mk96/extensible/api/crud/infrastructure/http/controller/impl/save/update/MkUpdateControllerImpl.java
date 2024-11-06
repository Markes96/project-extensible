package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update;

import org.mk96.extensible.api.crud.domain.service.save.update.MkUpdateService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update.all.MkUpdateAllControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.update.one.MkUpdateOneControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.MkUpdateController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.all.MkUpdateAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.update.one.MkUpdateOneController;
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
public class MkUpdateControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkUpdateController<BOD, RES> {

    @Autowired(required = false)
    private MkUpdateService<DOM> service;

    public MkUpdateControllerImpl(
            MkUpdateService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_update_controller();
    }

    @Delegate
    private MkUpdateOneController<BOD, RES> updateOne;

    @Delegate
    private MkUpdateAllController<BOD, RES> updateAll;

    @PostConstruct
    void init_update_controller() {
        updateOne = new MkUpdateOneControllerImpl<>(service, mapper);
        updateAll = new MkUpdateAllControllerImpl<>(service, mapper);
    }

}
