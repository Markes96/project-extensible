package org.mk96.extensible.api.crud.domain.port.save.insert;

import org.mk96.extensible.api.crud.domain.port.save.insert.all.MkInsertAllPort;
import org.mk96.extensible.api.crud.domain.port.save.insert.one.MkInsertOnePort;
import org.mk96.extensible.api.domain.model.MkDomain;

public interface MkInsertPort<DOM extends MkDomain>
	extends MkInsertOnePort<DOM>,
	MkInsertAllPort<DOM> {}
