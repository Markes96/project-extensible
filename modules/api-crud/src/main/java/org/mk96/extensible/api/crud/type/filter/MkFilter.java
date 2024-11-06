package org.mk96.extensible.api.crud.type.filter;

import java.util.List;
import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.filter.simple.flexible.MkFlexibleFilter;
import org.mk96.extensible.api.crud.type.filter.simple.id.MkIdFilter;
import org.mk96.extensible.api.crud.type.filter.simple.unique.MkUniqueFilter;
import org.mk96.extensible.api.domain.model.MkDomain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "filterType",
        visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MkIdFilter.class, name = "ID"),
    @JsonSubTypes.Type(value = MkUniqueFilter.class, name = "UNIQUE"),
    @JsonSubTypes.Type(value = MkFlexibleFilter.class, name = "FLEXIBLE"),
    @JsonSubTypes.Type(value = MkFlexibleFilter.class, name = "STRICT")
})

@Getter
@Setter
@FieldNameConstants
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class MkFilter<T extends MkObject> extends MkDomain {

    protected final MkFilterType filterType;
    protected MkFilterMatcher filterMatcher = MkFilterMatcher.EQUALS;

    public abstract <Tp extends MkObject> MkFilter<Tp> map(Function<T, Tp> mapper);
    
    public static <T extends MkObject, Tp extends MkObject> Function<MkFilter<T>, MkFilter<Tp>> transform(Function<T, Tp> mapper) {
		return filter -> filter.map(mapper);
    }
    
    public abstract List<Fields> getFields();

}
