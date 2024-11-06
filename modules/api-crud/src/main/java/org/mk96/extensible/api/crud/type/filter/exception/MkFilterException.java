package org.mk96.extensible.api.crud.type.filter.exception;

import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import lombok.Getter;

@Getter
public class MkFilterException extends MkCrudException {

    private static final long serialVersionUID = 1L;

    private final MkFilter<?> filter;

    public MkFilterException(MkFilter<?> filter, final Throwable e) {
        super(e);
        this.filter = filter;
    }

    public MkFilterException(MkFilter<?> filter, final String message) {
        super(message);
        this.filter = filter;
    }

    public MkFilterException(MkFilter<?> filter, final String message, final Throwable e) {
        super(message, e);
        this.filter = filter;
    }

}
