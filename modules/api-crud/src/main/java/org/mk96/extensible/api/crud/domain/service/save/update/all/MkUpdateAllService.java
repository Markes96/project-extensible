package org.mk96.extensible.api.crud.domain.service.save.update.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.update.MkUpdateSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkUpdateAllService<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> updateAll(List<MkUpdateSave<DOM>> updates);

}
