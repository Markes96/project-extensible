package org.mk96.extensible.api.crud.type.filter.simple.flexible.exception;

import org.mk96.extensible.api.crud.type.filter.simple.exception.MkSimpleFilterException;
import org.mk96.extensible.api.crud.type.filter.simple.flexible.MkFlexibleFilter;
import lombok.Getter;

@Getter
public class MkFlexibleFilterException extends MkSimpleFilterException {

    private static final long serialVersionUID = 1L;

    public MkFlexibleFilterException(MkFlexibleFilter<?> filter, final Throwable e) {
        super(filter, e);
    }

    public MkFlexibleFilterException(MkFlexibleFilter<?> filter, final String message) {
        super(filter, message);
    }

    public MkFlexibleFilterException(MkFlexibleFilter<?> filter, final String message, final Throwable e) {
        super(filter, message, e);
    }

}
