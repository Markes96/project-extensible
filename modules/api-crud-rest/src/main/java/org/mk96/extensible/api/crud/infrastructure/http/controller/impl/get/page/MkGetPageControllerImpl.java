package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get.page;

import java.util.List;

import org.mk96.extensible.api.crud.domain.service.get.page.MkGetPageService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.page.MkGetPageController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.response.impl.AbstractMkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkGetPageControllerImpl<DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkGetPageController<RES> {

    @Autowired(required = false)
    private MkGetPageService<DOM> service;

    public MkGetPageControllerImpl(
    		MkGetPageService<DOM> service,
            MkRestResponseMapper<DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("/get/page")
    public List<RES> getPage(Pageable pageable) {
        List<DOM> domResponse = service.getPage(pageable);
        return domResponse.stream()
        		.map(mapper::map).toList();
    }

}
