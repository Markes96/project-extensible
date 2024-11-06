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
        super(buildMessage(filter, message));
        this.filter = filter;
    }

    public MkFilterException(MkFilter<?> filter, final String message, final Throwable e) {
        super(buildMessage(filter, message), e);
        this.filter = filter;
    }

    private static String buildMessage(MkFilter<?> filter, final String message) {
        return "\r\n [ERROR]: " + message
             + "\r\n [FILTER]: " + filter.toString();
    }

}
