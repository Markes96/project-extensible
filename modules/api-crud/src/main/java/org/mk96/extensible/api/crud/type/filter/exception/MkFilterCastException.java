package org.mk96.extensible.api.crud.type.filter.exception;

import java.util.function.BiFunction;
import org.mk96.extensible.api.crud.type.filter.MkFilter;

@SuppressWarnings("rawtypes")
public class MkFilterCastException extends MkFilterException {

	private static final long serialVersionUID = 1L;

    private static BiFunction<MkFilter<?>, Class<? extends MkFilter>, String> ERROR_MESSAGE = (srcfilter, dstFilter) ->
	    "Error casting to " + dstFilter + " , source type: " + srcfilter.getClass().getSimpleName();

	public MkFilterCastException(MkFilter<?> srcFilter, Class<? extends MkFilter> dstFilter) {
		super(srcFilter, ERROR_MESSAGE.apply(srcFilter, dstFilter));
	}
}
