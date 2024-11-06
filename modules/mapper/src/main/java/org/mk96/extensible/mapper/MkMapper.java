package org.mk96.extensible.mapper;

import org.mk96.common.type.MkObject;

public interface MkMapper<SRC extends MkObject, DST extends MkObject> {

	DST map(SRC source);

}
