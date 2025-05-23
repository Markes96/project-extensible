package org.mk96.extensible.api.crud.application.delete.id.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.id.all.MkDeleteAllByIdPort;
import org.mk96.extensible.api.crud.domain.service.delete.id.all.MkDeleteAllByIdService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteAllByIdUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteAllByIdService<DOM, ID> {

	@Delegate
	@Autowired
	private MkDeleteAllByIdPort<DOM, ID> port;

}
