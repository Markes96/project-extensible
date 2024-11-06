package org.mk96.extensible.api.crud.type.save;

import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.type.save.safe.insert.MkInsertSave;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.crud.type.save.safe.update.MkUpdateSave;
import org.mk96.extensible.api.crud.type.save.simple.upsert.MkUpsertSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "updateType",
        visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MkInsertSave.class, name = "INSERT"),
    @JsonSubTypes.Type(value = MkUpsertSave.class, name = "UPSERT"),
    @JsonSubTypes.Type(value = MkUpdateSave.class, name = "UPDATE"),
    @JsonSubTypes.Type(value = MkMergeSave.class, name = "MERGE")
})

@Getter
@FieldNameConstants
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class MkSave<T extends MkObject> extends MkDomain {

	protected final T save;
	protected final MkSaveType updateType;

    public abstract <Tp extends MkObject> MkSave<Tp> map(Function<T, Tp> map);

}
