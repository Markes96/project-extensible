package org.mk96.extensible.api.crud.type.filter.simple;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.MkFilterType;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
public abstract class MkSimpleFilter<T extends MkObject> extends MkFilter<T> {

    protected final T filter;

	protected MkSimpleFilter(T filter, MkFilterType filterType) {
        super(filterType);
        this.filter = filter;
	}
	
	public static <T extends MkObject> boolean isCasteable(MkFilter<T> filter) {
		return filter instanceof MkSimpleFilter;
	}

}
