package org.mk96.extensible.api.crud.infrastructure.dto.exception;

import java.lang.reflect.Field;
import java.util.List;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;

public class MkNullStrictFilterException extends MkCrudException {

	private static final long serialVersionUID = 1L;
	
	private static final String NULL_FIELDS_MESSAGE = "Can not build Strict filter cos all fields are null";

	public MkNullStrictFilterException(List<Field> fields) {
		super(buildMessage(fields));
	}
	
	private static String buildMessage(List<Field> fields) {
		
		StringBuilder stringBuilder = new StringBuilder(NULL_FIELDS_MESSAGE);
		stringBuilder.append(":\r\n");
		fields.forEach(field -> {
			stringBuilder
				.append("name: ").append(field.getName())
				.append("type: ").append(field.getType().getSimpleName());
		});
		
		return stringBuilder.toString();
	}

}
