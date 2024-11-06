package org.mk96.extensible.mapper.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.mapper.type.MkMapperException;
import org.modelmapper.ExpressionMap;
import org.modelmapper.internal.typetools.TypeResolver;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MkMapperUtils {

	public Class<?>[] resolveRawArguments(final Class<?> genericType, final Class<?> subType) {
		return TypeResolver.resolveRawArguments(genericType, subType);
	}

	@SuppressWarnings("unchecked")
	public <SRC, DST, SRCv, DSTv> ExpressionMap<SRC, DST> createMapping(
			final SourceGetter<SRC> getter,
			final DestinationSetter<DST, DSTv> setter,
			final Function<SRCv, DSTv> converter) {

		return mapper -> mapper
				.when(ctx -> ctx.getSource() != null)
				.using(ctx -> converter.apply((SRCv) ctx.getSource()))
				.map(getter, setter);

	}

	public <T> SourceGetter<T> findSrcGetter(final String fieldName, final Class<T> fieldType) {

		final Method getter = MkReflectionUtils.findGetter(fieldType, fieldName);
		return src -> {
			try {
				return MkReflectionUtils.invokeMethod(src, getter);
			} catch (final InvocationTargetException e) {
				throw new MkMapperException(e);
			}
		};

	}

	public <T, V> DestinationSetter<T, V> findDstSetter(final String dstName, final Class<T> dstType) {

		final Method setter = MkReflectionUtils.findSetter(dstType, dstName);

		return (dst, value) -> {
			try {
				MkReflectionUtils.invokeMethod(dst, setter, value);
			} catch (final InvocationTargetException e) {
				throw new MkMapperException(e);
			}
		};
	}

}
