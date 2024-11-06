package org.mk96.extensible.api.crud.domain.port.save.merge.many;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkMergeManyPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> mergeMany(MkMergeSave<DOM> merge);

}
