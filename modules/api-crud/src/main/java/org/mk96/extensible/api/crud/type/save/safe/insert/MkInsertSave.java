package org.mk96.extensible.api.crud.type.save.safe.insert;

import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import org.mk96.extensible.api.crud.type.save.safe.MkSafeSave;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(MkSafeSave.Fields.filter)
public class MkInsertSave<T extends MkObject> extends MkSafeSave<T> {

    @JsonCreator
	public MkInsertSave(@JsonProperty(MkSave.Fields.save) T save) {
		super(new MkIdFilter<>(save), save, MkSaveType.INSERT);
	}

    @Override
    public <Tp extends MkObject> MkSave<Tp> map(Function<T, Tp> map) {
        Tp save = map.apply(this.save);
        return new MkInsertSave<>(save);
    }

}
