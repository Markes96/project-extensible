package org.mk96.extensible.api.infrastucture.http.mapper;

import org.mk96.common.test.template.AbstractMkTestTemplate;
import org.mk96.common.test.template.annotation.MkTestTemplate;
import org.mk96.common.test.template.annotation.MkTestTemplateConfiguration;
import org.mk96.extensible.api.infrastucture.http.mapper.requirement.MkControllerModelMapperImpl;
import org.mk96.extensible.api.infrastucture.http.mapper.requirement.type.DomainObject;
import org.mk96.extensible.api.infrastucture.http.mapper.requirement.type.RequestDto;
import org.mk96.extensible.api.infrastucture.http.mapper.requirement.type.ResponseDto;

@MkTestTemplateConfiguration(path = "api/infrastructure/http/mapper")
public class MkControllerModelMapperTest extends AbstractMkTestTemplate {

	@MkTestTemplate(resultName = "DomainResult.json")
	DomainObject reqToDomTest() {

		final MkControllerModelMapperImpl mapper = new MkControllerModelMapperImpl();

		final RequestDto requestDto = new RequestDto();
		final DomainObject domainObject = mapper.map(requestDto);

		return domainObject;
	}

	@MkTestTemplate(resultName = "ResponseResult.json")
	ResponseDto domToResTest() {

		final MkControllerModelMapperImpl mapper = new MkControllerModelMapperImpl();

		final DomainObject domainObject = reqToDomTest();
		final ResponseDto responseDto = mapper.map(domainObject);

		return responseDto;
	}

}
