package org.mk96.extensible.api.crud.type.filter.simple.exception;

import org.mk96.extensible.api.crud.type.filter.exception.MkFilterException;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import lombok.Getter;

@Getter
public class MkSimpleFilterException extends MkFilterException {

    private static final long serialVersionUID = 1L;

    public MkSimpleFilterException(MkSimpleFilter<?> filter, final Throwable e) {
        super(filter, e);
    }

    public MkSimpleFilterException(MkSimpleFilter<?> filter, final String message) {
        super(filter, message);
    }

    public MkSimpleFilterException(MkSimpleFilter<?> filter, final String message, final Throwable e) {
        super(filter, message, e);
    }

}
