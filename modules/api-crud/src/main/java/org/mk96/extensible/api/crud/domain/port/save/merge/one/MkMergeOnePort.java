package org.mk96.extensible.api.crud.domain.port.save.merge.one;

import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.domain.port.MkPort;

public interface MkMergeOnePort<DOM extends MkDomain>
	extends MkPort<DOM> {

	DOM mergeOne(MkMergeSave<DOM> merge);

}
