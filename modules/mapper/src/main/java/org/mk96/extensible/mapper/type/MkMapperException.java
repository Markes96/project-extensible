package org.mk96.extensible.mapper.type;

import org.mk96.extensible.type.MkExtensibleException;

public class MkMapperException extends MkExtensibleException {

	private static final long serialVersionUID = 1L;

	public MkMapperException(final Throwable e) {
		super(e);
	}

	public MkMapperException(final String message) {
		super(message);
	}

	public MkMapperException(final String message, final Throwable e) {
		super(message, e);
	}

}
