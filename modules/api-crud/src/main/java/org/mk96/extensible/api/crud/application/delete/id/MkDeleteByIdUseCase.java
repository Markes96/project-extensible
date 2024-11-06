package org.mk96.extensible.api.crud.application.delete.id;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.id.MkDeleteByIdPort;
import org.mk96.extensible.api.crud.domain.service.delete.id.MkDeleteByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteByIdUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkDeleteByIdPort<DOM, ID> port;

}
