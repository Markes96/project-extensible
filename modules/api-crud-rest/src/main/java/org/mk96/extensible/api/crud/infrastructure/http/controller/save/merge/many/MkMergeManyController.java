package org.mk96.extensible.api.crud.infrastructure.http.controller.save.merge.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkMergeManyController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkRestController<BOD, RES> {

    @PutMapping("/merge/many")
    List<RES> mergeMany(@RequestBody MkMergeSave<BOD> merge);

}
