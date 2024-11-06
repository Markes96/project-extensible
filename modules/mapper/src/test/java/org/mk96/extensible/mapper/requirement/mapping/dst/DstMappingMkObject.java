package org.mk96.extensible.mapper.requirement.mapping.dst;

import org.mk96.common.type.MkObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class DstMappingMkObject extends MkObject {

	private String name;

	private String dstFcName;
	private String dstStriName;

	private String conv;
	private String dstFcConv;
	private String dstStriConv;

	private DstMappingSubMkObject sub;
	private DstMappingSubMkObject dstFcSub;
	private DstMappingSubMkObject dstStriSub;

}
