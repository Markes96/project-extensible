package org.mk96.extensible.api.crud.type.save.simple.upsert;

import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import org.mk96.extensible.api.crud.type.save.simple.MkSimpleSave;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MkUpsertSave<T extends MkObject> extends MkSimpleSave<T> {

    @JsonCreator
	public MkUpsertSave(@JsonProperty(MkSave.Fields.save) T update) {
		super(update, MkSaveType.UPSERT);
	}

    @Override
    public <Tp extends MkObject> MkSave<Tp> map(Function<T, Tp> map) {
        Tp save = map.apply(this.save);
        return new MkUpsertSave<>(save);
    }

}
