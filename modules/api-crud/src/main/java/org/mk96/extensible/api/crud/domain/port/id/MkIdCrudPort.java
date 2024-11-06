package org.mk96.extensible.api.crud.domain.port.id;

import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkIdCrudPort<DOM extends MkDomain, ID>
	extends MkIdCreatePort<DOM, ID>,
	MkIdUpdatePort<DOM, ID>,
	MkIdFindPort<DOM, ID>,
	MkIdDeletePort<DOM, ID> {}