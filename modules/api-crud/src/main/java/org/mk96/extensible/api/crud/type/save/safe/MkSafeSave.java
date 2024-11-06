package org.mk96.extensible.api.crud.type.save.safe;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
public abstract class MkSafeSave<T extends MkObject> extends MkSave<T> {

    protected final MkFilter<T> filter;

	public MkSafeSave(MkFilter<T> filter, T save, MkSaveType saveType) {
		super(save, saveType);
		this.filter = filter;
	}

}
