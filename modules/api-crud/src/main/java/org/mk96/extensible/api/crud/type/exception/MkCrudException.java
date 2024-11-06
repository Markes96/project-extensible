package org.mk96.extensible.api.crud.type.exception;

import org.mk96.common.type.MkException;

public class MkCrudException extends MkException {

	private static final long serialVersionUID = 1L;

	public MkCrudException(final Throwable e) {
		super(e);
	}

	public MkCrudException(final String message) {
		super(message);
	}

	public MkCrudException(final String message, final Throwable e) {
		super(message, e);
	}

}
