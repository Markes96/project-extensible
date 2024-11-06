package org.mk96.extensible.api.util;

import java.lang.reflect.Field;
import java.util.List;

import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.type.MkBeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MkBeanCreationUtils {

	public void checkAutowired(Object bean) {
		
		List<Field> fields = MkReflectionUtils.getAllFields(bean);
		
		for (Field field : fields) {
			if(field.isAnnotationPresent(Autowired.class) && MkReflectionUtils.isNullField(bean, field)) {
				throw new MkBeanCreationException(bean, field);
			}	
		}
		
	}
	
}
