package org.mk96.extensible.api.crud.application;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.MkCrudPort;
import org.mk96.extensible.api.crud.domain.service.MkCrudService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkCrudUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkCrudService<DOM, ID> {

	@Delegate
	@Autowired
	protected MkCrudPort<DOM, ID> port;

}
