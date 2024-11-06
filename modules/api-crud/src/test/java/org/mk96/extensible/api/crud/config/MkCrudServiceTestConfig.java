package org.mk96.extensible.api.crud.config;

import org.mk96.extensible.api.crud.requirement.application.CrudUseCase;
import org.mk96.extensible.api.crud.requirement.infrastructure.CrudAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
		CrudAdapter.class,
		CrudUseCase.class
})
public class MkCrudServiceTestConfig {}
