package org.mk96.extensible.type;

import org.mk96.common.type.MkException;

public class MkExtensibleException extends MkException {

	private static final long serialVersionUID = 1L;

	public MkExtensibleException(final Throwable e) {
		super(e);
	}

	public MkExtensibleException(final String message) {
		super(message);
	}

	public MkExtensibleException(final String message, final Throwable e) {
		super(message, e);
	}

}
