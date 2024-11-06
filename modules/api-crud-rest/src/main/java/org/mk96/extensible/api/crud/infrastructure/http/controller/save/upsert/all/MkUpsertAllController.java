package org.mk96.extensible.api.crud.infrastructure.http.controller.save.upsert.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.infrastructure.http.controller.MkRestController;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MkUpsertAllController<BOD extends MkRestBodyDto, RES extends MkRestResponseDto>
	extends MkRestController<BOD, RES> {

    @PutMapping("/upsert/all")
	List<RES> upsertAll(@RequestBody List<MkUpsertSave<BOD>> upserts);

}
