package org.mk96.extensible.api.crud.type.filter.simple.flexible;
import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.MkFilterType;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class MkFlexibleFilter<T extends MkObject> extends MkSimpleFilter<T> {

    @JsonCreator
	public MkFlexibleFilter(@JsonProperty(MkSimpleFilter.Fields.filter) T filter) {
        super(filter, MkFilterType.FLEXIBLE);
    }

    @Override
    public <Tp extends MkObject> MkFlexibleFilter<Tp> map(Function<T, Tp> mapper) {
        Tp filter = mapper.apply(this.filter);
        return new MkFlexibleFilter<>(filter);
    }

}
