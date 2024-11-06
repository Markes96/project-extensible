package org.mk96.extensible.api.crud.domain.port.save.insert.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkInsertAllPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> insertAll(List<MkInsertSave<DOM>> inserts);

}
