package org.mk96.extensible.api.crud.type.filter.simple.strict.exception;

import org.mk96.extensible.api.crud.type.filter.simple.exception.MkSimpleFilterException;
import org.mk96.extensible.api.crud.type.filter.simple.strict.MkStrictFilter;
import lombok.Getter;

@Getter
public class MkStrictFilterException extends MkSimpleFilterException {

    private static final long serialVersionUID = 1L;

    public MkStrictFilterException(MkStrictFilter<?> filter, final Throwable e) {
        super(filter, e);
    }

    public MkStrictFilterException(MkStrictFilter<?> filter, final String message) {
        super(filter, message);
    }

    public MkStrictFilterException(MkStrictFilter<?> filter, final String message, final Throwable e) {
        super(filter, message, e);
    }

}
