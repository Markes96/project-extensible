package org.mk96.extensible.api.crud.domain.service.save.insert.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkInsertAllService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> insertAll(List<MkInsertSave<DOM>> inserts);

}
