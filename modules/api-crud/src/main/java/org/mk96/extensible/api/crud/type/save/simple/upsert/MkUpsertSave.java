package org.mk96.extensible.api.crud.type.save.simple.upsert;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import org.mk96.extensible.api.crud.type.save.simple.MkSimpleSave;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(MkSave.Fields.saveType)
public class MkUpsertSave<T extends MkObject> extends MkSimpleSave<T> {

    @JsonCreator
	public MkUpsertSave(T update) {
		super(update, MkSaveType.UPSERT);
	}

    @Override
    public <Tp extends MkObject> MkUpsertSave<Tp> map(Function<T, Tp> map) {
        Tp save = map.apply(this.save);
        return new MkUpsertSave<>(save);
    }

}
