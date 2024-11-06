package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkDeleteManyByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
    extends MkRestController<BOD, RES> {

    @DeleteMapping("/delete/many/filter")
    List<RES> deleteManyByFilter(@RequestBody MkFilter<BOD> filter);

}
