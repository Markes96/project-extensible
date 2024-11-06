package org.mk96.extensible.api.infrastructure.persistence.mapper;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;

public interface MkPersistenceMapper<DOM extends MkDomain, EN extends MkEntity> {

	DOM map(EN request);

	EN map(DOM request);

}
