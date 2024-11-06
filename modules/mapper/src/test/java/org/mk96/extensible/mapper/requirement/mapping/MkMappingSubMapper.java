package org.mk96.extensible.mapper.requirement.mapping;

import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.requirement.mapping.dst.DstMappingSubMkObject;
import org.mk96.extensible.mapper.requirement.mapping.src.SrcMappingSubMkObject;

public final class MkMappingSubMapper extends MkModelMapper<SrcMappingSubMkObject, DstMappingSubMkObject> {

	{
		addMapping(SrcMappingSubMkObject.Fields.stri, (final String value) -> "ConvertedValue");
	}

}
