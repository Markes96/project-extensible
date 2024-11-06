package org.mk96.extensible.api.crud.type.filter.simple.unique.exception;

import org.mk96.extensible.api.crud.type.filter.simple.exception.MkSimpleFilterException;
import org.mk96.extensible.api.crud.type.filter.simple.unique.MkUniqueFilter;
import lombok.Getter;

@Getter
public class MkUniqueFilterException extends MkSimpleFilterException {

    private static final long serialVersionUID = 1L;

    public MkUniqueFilterException(MkUniqueFilter<?> filter, final Throwable e) {
        super(filter, e);
    }

    public MkUniqueFilterException(MkUniqueFilter<?> filter, final String message) {
        super(filter, message);
    }

    public MkUniqueFilterException(MkUniqueFilter<?> filter, final String message, final Throwable e) {
        super(filter, message, e);
    }

}
