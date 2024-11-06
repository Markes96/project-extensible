package org.mk96.extensible.api.crud.application.get;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.get.MkGetPort;
import org.mk96.extensible.api.crud.domain.service.get.MkGetService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkGetUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkGetService<DOM> {

	@Delegate
	@Autowired(required = false)
	private MkGetPort<DOM> port;
	
}
