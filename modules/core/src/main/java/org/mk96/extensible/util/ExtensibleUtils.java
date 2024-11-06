package org.mk96.extensible.util;

import java.util.Objects;
import org.mk96.extensible.type.MkExtensibleException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExtensibleUtils {

	public <T> void checkAutowired(
			final T obj,
			final Class<?> contentType,
			final Class<T> fieldType) {

		if (Objects.isNull(obj))
			throw new MkExtensibleException(
					"Error creating bean with name " + contentType.getSimpleName()
							+ " cos no such bean of type " + fieldType.getSimpleName());

	}

}
