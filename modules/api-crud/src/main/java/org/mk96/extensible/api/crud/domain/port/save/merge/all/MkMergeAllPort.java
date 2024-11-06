package org.mk96.extensible.api.crud.domain.port.save.merge.all;

import java.util.List;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkMergeAllPort<DOM extends MkDomain>
	extends MkPort<DOM> {

	List<DOM> mergeAll(List<MkMergeSave<DOM>> merges);

}
