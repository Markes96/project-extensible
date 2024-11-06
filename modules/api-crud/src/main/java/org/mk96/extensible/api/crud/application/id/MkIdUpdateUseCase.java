package org.mk96.extensible.api.crud.application.id;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.id.MkIdUpdatePort;
import org.mk96.extensible.api.crud.domain.service.id.MkIdUpdateService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkIdUpdateUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkIdUpdateService<DOM, ID> {

	@Delegate
	@Autowired
	private MkIdUpdatePort<DOM, ID> port;

}
