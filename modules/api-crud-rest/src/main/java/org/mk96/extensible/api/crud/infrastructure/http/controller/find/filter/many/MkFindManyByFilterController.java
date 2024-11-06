package org.mk96.extensible.api.crud.infrastructure.http.controller.find.filter.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkFindManyByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkRestController<BOD, RES> {

    @PostMapping("/find/many/filter")
	List<RES> findManyByFilter(@RequestBody MkFilter<BOD> filters);

}
