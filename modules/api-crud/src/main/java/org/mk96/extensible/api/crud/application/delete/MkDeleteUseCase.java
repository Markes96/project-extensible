package org.mk96.extensible.api.crud.application.delete;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.MkDeletePort;
import org.mk96.extensible.api.crud.domain.service.delete.MkDeleteService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteUseCase<DOM extends MkDomain, ID>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteService<DOM, ID> {
	
	@Delegate
	@Autowired
	private MkDeletePort<DOM, ID> port;

}
