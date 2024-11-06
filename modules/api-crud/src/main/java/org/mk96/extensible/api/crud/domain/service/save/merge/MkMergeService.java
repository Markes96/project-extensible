package org.mk96.extensible.api.crud.domain.service.save.merge;

import org.mk96.extensible.api.crud.domain.service.save.merge.all.MkMergeAllService;
import org.mk96.extensible.api.crud.domain.service.save.merge.one.MkMergeOneService;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkMergeService<DOM extends MkDomain>
	extends MkMergeOneService<DOM>,
	MkMergeAllService<DOM> {}
