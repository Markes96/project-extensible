package org.mk96.extensible.api.crud.application.get.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.get.all.MkGetAllPort;
import org.mk96.extensible.api.crud.domain.service.get.all.MkGetAllService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkGetAllUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkGetAllService<DOM> {

	@Delegate
	@Autowired(required = false)
	private MkGetAllPort<DOM> port;
	
}
