package org.mk96.extensible.api.infrastructure.persistence.jpa.type;

import org.mk96.extensible.api.infrastructure.persistence.type.MkPersistenceException;

public class MkJpaExcetion extends MkPersistenceException {

	private static final long serialVersionUID = 1L;

	public MkJpaExcetion(final Throwable e) {
		super(e);
	}

	public MkJpaExcetion(final String message) {
		super(message);
	}

	public MkJpaExcetion(final String message, final Throwable e) {
		super(message, e);
	}
	
}
