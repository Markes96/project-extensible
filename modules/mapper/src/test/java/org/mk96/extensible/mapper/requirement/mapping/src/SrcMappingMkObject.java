package org.mk96.extensible.mapper.requirement.mapping.src;

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
public class SrcMappingMkObject extends MkObject {

	private String name = "same name";

	private String scrFcName = "Name Src to name Dst function";
	private String srcStriName = "Name Src to name Dst string";

	private String conv = "OriginalValue";
	private String scrFcConv = "OriginalValue";
	private String srcStriConv = "OriginalValue";

	private SrcMappingSubMkObject sub = new SrcMappingSubMkObject();
	private SrcMappingSubMkObject srcFcSub = new SrcMappingSubMkObject();
	private SrcMappingSubMkObject srcStriSub = new SrcMappingSubMkObject();

}
