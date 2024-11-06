package org.mk96.extensible.api.crud.type.filter.exception;

import java.lang.reflect.Field;
import java.util.List;
import org.mk96.extensible.api.crud.type.filter.MkFilter;

public class MkFilterNullException extends MkFilterException {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_MESSAGE = "Can't build filter cos filter fields are null";

	public MkFilterNullException(MkFilter<?> filter, List<Field> filterFields) {
		super(filter, buildMessage(filterFields));
	}

    private static String buildMessage(List<Field> filterFields) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\r\n    [MESSAGE]");
        stringBuilder.append(ERROR_MESSAGE);
        stringBuilder.append("\r\n    [FILTER FIELDS]");
        filterFields.forEach(field -> {
        stringBuilder.append("\\r\\n    * name: ").append(field.getName())
                     .append("          * type: ").append(field.getType().getSimpleName());
        });

        return stringBuilder.toString();
    }

}
