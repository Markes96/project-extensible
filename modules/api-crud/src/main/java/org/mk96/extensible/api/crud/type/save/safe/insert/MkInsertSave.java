package org.mk96.extensible.api.crud.type.save.safe.insert;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import org.mk96.extensible.api.crud.type.save.safe.MkSafeSave;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties({
	MkSave.Fields.saveType,
	MkSafeSave.Fields.filter
})
public class MkInsertSave<T extends MkObject> extends MkSafeSave<T> {

    @JsonCreator
	public MkInsertSave(T save) {
		super(new MkIdFilter<>(save), save, MkSaveType.INSERT);
	}

    @Override
    public <Tp extends MkObject> MkInsertSave<Tp> map(Function<T, Tp> mapper) {
        Tp save = mapper.apply(this.save);
        return new MkInsertSave<>(save);
    }

}
