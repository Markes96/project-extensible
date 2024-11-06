package org.mk96.extensible.api.crud.type.save.safe.merge;

import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.save.MkSave;
import org.mk96.extensible.api.crud.type.save.MkSaveType;
import org.mk96.extensible.api.crud.type.save.safe.MkSafeSave;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MkMergeSave<T extends MkObject> extends MkSafeSave<T> {

    @JsonCreator
	public MkMergeSave(
	        @JsonProperty(MkSafeSave.Fields.filter) MkFilter<T> filter,
	        @JsonProperty(MkSave.Fields.save) T save) {
	    super(filter, save, MkSaveType.MERGE);
	}

    @Override
    public <Tp extends MkObject> MkSave<Tp> map(Function<T, Tp> map) {
        Tp save = map.apply(this.save);
        MkFilter<Tp> filter = this.filter.map(map);
        return new MkMergeSave<>(filter, save);
    }

}
