package org.mk96.extensible.api.crud.infrastructure.http.controller.impl.get.all;

import java.util.List;

import org.mk96.extensible.api.crud.domain.service.get.all.MkGetAllService;
import org.mk96.extensible.api.crud.infrastructure.http.controller.get.all.MkGetAllController;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.response.impl.AbstractMkResponseRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MkGetAllControllerImpl<DOM extends MkDomain, RES extends MkRestResponseDto, ID>
    extends AbstractMkResponseRestController<DOM, RES>
    implements MkGetAllController<RES> {

    @Autowired(required = false)
    private MkGetAllService<DOM> service;

    public MkGetAllControllerImpl(
    		MkGetAllService<DOM> service,
            MkRestResponseMapper<DOM, RES> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("/get/all")
    public List<RES> getAll() {
        List<DOM> domResponse = service.getAll();
        return domResponse.stream()
        		.map(mapper::map).toList();
    }

}
