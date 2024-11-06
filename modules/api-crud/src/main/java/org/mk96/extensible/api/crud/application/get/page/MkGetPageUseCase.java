package org.mk96.extensible.api.crud.application.get.page;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.get.page.MkGetPagePort;
import org.mk96.extensible.api.crud.domain.service.get.page.MkGetPageService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkGetPageUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkGetPageService<DOM> {

	@Delegate
	@Autowired(required = false)
	private MkGetPagePort<DOM> port;
	
}
