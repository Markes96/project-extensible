package org.mk96.extensible.api.crud.type.filter.simple.id.exception;

import org.mk96.extensible.api.crud.type.filter.simple.exception.MkSimpleFilterException;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import lombok.Getter;

@Getter
public class MkIdFilterException extends MkSimpleFilterException {

    private static final long serialVersionUID = 1L;

    public MkIdFilterException(MkIdFilter<?> filter, final Throwable e) {
        super(filter, e);
    }

    public MkIdFilterException(MkIdFilter<?> filter, final String message) {
        super(filter, message);
    }

    public MkIdFilterException(MkIdFilter<?> filter, final String message, final Throwable e) {
        super(filter, message, e);
    }

}
