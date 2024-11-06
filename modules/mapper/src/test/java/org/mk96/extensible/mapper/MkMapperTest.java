package org.mk96.extensible.mapper;

import org.mk96.common.test.template.AbstractMkTestTemplate;
import org.mk96.common.test.template.annotation.MkTestTemplate;
import org.mk96.common.test.template.annotation.MkTestTemplateConfiguration;
import org.mk96.extensible.mapper.requirement.mapping.MkMappingMapper;
import org.mk96.extensible.mapper.requirement.mapping.dst.DstMappingMkObject;
import org.mk96.extensible.mapper.requirement.mapping.src.SrcMappingMkObject;
import org.mk96.extensible.mapper.requirement.primitives.MkPrimitivesMapper;
import org.mk96.extensible.mapper.requirement.primitives.dst.DstPrimitiveMkObject;
import org.mk96.extensible.mapper.requirement.primitives.src.SrcPrimitiveMkObject;

@MkTestTemplateConfiguration(path = "mapper")
public class MkMapperTest extends AbstractMkTestTemplate {

	@MkTestTemplate(resultName = "primitive.json")
	DstPrimitiveMkObject primitiveMapTest() {

		final MkPrimitivesMapper mapper = new MkPrimitivesMapper();
		return mapper.map(new SrcPrimitiveMkObject());
	}

	@MkTestTemplate(resultName = "mapping.json")
	DstMappingMkObject mappingMapTest() {

		final MkMappingMapper mapper = new MkMappingMapper();
		return mapper.map(new SrcMappingMkObject());
	}

}
