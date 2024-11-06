package org.mk96.extensible.api.crud.infrastructure.dto.exception;

import java.lang.reflect.Field;
import java.util.List;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;

public class MkNullIdFilterException extends MkCrudException {

	private static final long serialVersionUID = 1L;
	
	private static final String NULL_ID_MESSAGE = "Can not build id filter cos id is null";

	public MkNullIdFilterException(List<Field> fields) {
		super(buildMessage(fields));
	}
	
	private static String buildMessage(List<Field> fields) {
		
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
