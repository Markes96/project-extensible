package org.mk96.extensible.api.type;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import org.springframework.beans.factory.BeanCreationException;

public class MkBeanCreationException extends BeanCreationException {

	private static final long serialVersionUID = 1L;
	
	private static String MESSAGE = """
			
			Field "{0}" in "{1}"
			required a bean of type "{2}"
			""";

	public MkBeanCreationException(Object bean, Field field) {
		super(
				bean.getClass().getSimpleName(), 
				MessageFormat.format(
						MESSAGE,
						field.getName(), 
						bean.getClass().getName(),
						field.getType()
				)
		);
	}

}
