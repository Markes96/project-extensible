package org.mk96.extensible.api.crud.infrastructure.http.controller.delete.filter.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkDeleteAllByFilterController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
    extends MkRestController<BOD, RES> {

    @DeleteMapping("/delete/all/filter")
    List<RES> deleteAllByFilter(@RequestBody List<MkFilter<BOD>> filters);

}
