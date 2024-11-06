package org.mk96.extensible.api.crud.application.delete.id.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.id.one.MkDeleteOneByIdPort;
import org.mk96.extensible.api.crud.domain.service.delete.id.one.MkDeleteOneByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteOneByIdUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteOneByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkDeleteOneByIdPort<DOM, ID> port;

}
