package org.mk96.extensible.api.infrastucture.http.controller.requitement;

import org.mk96.extensible.api.infrastucture.http.controller.requitement.impl.MkController;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.impl.MkControllerMapper;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.impl.MkUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
		MkController.class,
		MkUseCase.class,
		MkControllerMapper.class
})
public class MkControllerTestConfig {}
