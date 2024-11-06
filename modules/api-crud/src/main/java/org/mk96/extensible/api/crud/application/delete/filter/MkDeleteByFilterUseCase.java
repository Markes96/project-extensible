package org.mk96.extensible.api.crud.application.delete.filter;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.filter.MkDeleteByFilterPort;
import org.mk96.extensible.api.crud.domain.service.delete.filter.MkDeleteByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteByFilterUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkDeleteByFilterPort<DOM> port;
	
}
