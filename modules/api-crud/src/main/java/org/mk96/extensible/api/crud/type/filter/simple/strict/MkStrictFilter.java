package org.mk96.extensible.api.crud.type.filter.simple.strict;
import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.MkFilter;
import org.mk96.extensible.api.crud.type.filter.MkFilterType;
import org.mk96.extensible.api.crud.type.filter.simple.MkSimpleFilter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MkStrictFilter<T extends MkObject> extends MkSimpleFilter<T> {

    @JsonCreator
	public MkStrictFilter(@JsonProperty(MkSimpleFilter.Fields.filter) T filter) {
        super(filter, MkFilterType.STRICT);
    }

    @Override
    public <Tp extends MkObject> MkFilter<Tp> map(Function<T, Tp> mapper) {
        Tp filter = mapper.apply(this.filter);
        return new MkStrictFilter<>(filter);
    }
}
