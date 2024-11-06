package org.mk96.extensible.mapper.requirement.mapping;

import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.requirement.mapping.dst.DstMappingMkObject;
import org.mk96.extensible.mapper.requirement.mapping.src.SrcMappingMkObject;

public final class MkMappingMapper
	extends MkModelMapper<SrcMappingMkObject, DstMappingMkObject> {

	{

		// changeName
		addMapping(SrcMappingMkObject::getScrFcName, DstMappingMkObject::setDstFcName);
		addMapping(SrcMappingMkObject.Fields.srcStriName, DstMappingMkObject.Fields.dstStriName);

		// converter value
		addMapping(SrcMappingMkObject.Fields.conv, this::convertString);
		addMapping(SrcMappingMkObject::getScrFcConv, DstMappingMkObject::setDstFcConv,
				this::convertString);
		addMapping(SrcMappingMkObject.Fields.srcStriConv, DstMappingMkObject.Fields.dstStriConv,
				this::convertString);

		// converter by submapper
		final MkMappingSubMapper subMapper = new MkMappingSubMapper();

		addMapping(SrcMappingMkObject.Fields.sub, subMapper);
		addMapping(SrcMappingMkObject::getSrcFcSub, DstMappingMkObject::setDstFcSub, subMapper);
		addMapping(SrcMappingMkObject.Fields.srcStriSub, DstMappingMkObject.Fields.dstStriSub,
				subMapper);

	}

	private String convertString(final String in) {
		return "ConvertedValue";
	}
}
