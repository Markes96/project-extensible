package org.mk96.extensible.api.crud.type.filter.simple.id.exception;

import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.util.MkCrudUtils;

public class MkNullIdFilterException extends MkIdFilterException {

	private static final long serialVersionUID = 1L;

	private static final String NULL_ID_MESSAGE = "Can not build id filter cos id is null";

	public MkNullIdFilterException(MkIdFilter<?> filter) {
		super(filter, buildMessage);
	}

	private static String buildMessage(MkIdFilter<?> filter) {

	    MkCrudUtils.findIdFields(filter.getFilter());

		StringBuilder stringBuilder = new StringBuilder(NULL_ID_MESSAGE);
		stringBuilder.append(":\r\n");
		fields.forEach(field -> {
			stringBuilder
				.append("name: ").append(field.getName())
				.append("type: ").append(field.getType().getSimpleName());
		});

		return stringBuilder.toString();
	}

}
