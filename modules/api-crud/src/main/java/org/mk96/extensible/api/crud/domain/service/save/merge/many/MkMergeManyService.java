package org.mk96.extensible.api.crud.domain.service.save.merge.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.service.MkService;

public interface MkMergeManyService<DOM extends MkDomain>
	extends MkService<DOM> {

	List<DOM> mergeMany(MkMergeSave<DOM> merge);

}
