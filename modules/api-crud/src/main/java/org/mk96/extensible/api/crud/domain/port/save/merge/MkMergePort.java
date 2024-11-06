package org.mk96.extensible.api.crud.domain.port.save.merge;

import org.mk96.extensible.api.crud.domain.port.save.merge.all.MkMergeAllPort;
import org.mk96.extensible.api.crud.domain.port.save.merge.one.MkMergeOnePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkMergePort<DOM extends MkDomain>
	extends MkMergeOnePort<DOM>,
	MkMergeAllPort<DOM> {}
