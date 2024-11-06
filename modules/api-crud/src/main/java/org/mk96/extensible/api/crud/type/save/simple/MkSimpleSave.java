package org.mk96.extensible.api.crud.type.save.simple;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;

public abstract class MkSimpleSave<T extends MkObject> extends MkSave<T> {

	public MkSimpleSave(T update, MkSaveType saveType) {
		super(update, MkSaveType.UPSERT);
	}

}
