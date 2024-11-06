package org.mk96.extensible.api.infrastructure.persistence.type;

import org.mk96.common.type.MkException;

public class MkPersistenceException extends MkException {

	private static final long serialVersionUID = 1L;

	public MkPersistenceException(final Throwable e) {
		super(e);
	}

	public MkPersistenceException(final String message) {
		super(message);
	}

	public MkPersistenceException(final String message, final Throwable e) {
		super(message, e);
	}

}
