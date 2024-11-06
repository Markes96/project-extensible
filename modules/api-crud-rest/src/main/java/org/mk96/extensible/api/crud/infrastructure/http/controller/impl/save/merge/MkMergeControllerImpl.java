package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge;

import org.mk96.extensible.api.crud.domain.service.save.merge.MkMergeService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.all.MkMergeAllControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.many.MkMergeManyControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.impl.save.merge.one.MkMergeOneControllerImpl;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.MkMergeController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.all.MkMergeAllController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.many.MkMergeManyController;
import org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.one.MkMergeOneController;
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
public class MkMergeControllerImpl<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
    extends AbstractMkRestController<BOD, DOM, RES>
    implements MkMergeController<BOD, RES> {

    @Autowired(required = false)
    private MkMergeService<DOM> service;

    public MkMergeControllerImpl(
            MkMergeService<DOM> service,
            MkRestMapper<BOD, DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
        init_merge_controller();
    }

    @Delegate
    private MkMergeOneController<BOD, RES> mergeOne;

    @Delegate
    private MkMergeManyController<BOD, RES> mergeMany;

    @Delegate
    private MkMergeAllController<BOD, RES> mergeAll;

    @PostConstruct
    void init_merge_controller() {
        mergeOne = new MkMergeOneControllerImpl<>(service, mapper);
        mergeMany = new MkMergeManyControllerImpl<>(service, mapper);
        mergeAll = new MkMergeAllControllerImpl<>(service, mapper);
    }

}
