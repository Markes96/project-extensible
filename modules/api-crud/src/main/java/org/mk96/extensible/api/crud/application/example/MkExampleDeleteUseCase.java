package org.mk96.extensible.api.crud.application.example;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.example.MkExampleDeletePort;
import org.mk96.extensible.api.crud.domain.service.example.MkExampleDeleteService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkExampleDeleteUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkExampleDeleteService<DOM> {

	@Delegate
	@Autowired
	protected MkExampleDeletePort<DOM> port;

}
