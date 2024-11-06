package org.mk96.extensible.api.crud.application.delete.filter.one;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.filter.one.MkDeleteOneByFilterPort;
import org.mk96.extensible.api.crud.domain.service.delete.filter.one.MkDeleteOneByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteOneByFilterUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteOneByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkDeleteOneByFilterPort<DOM> port;
	
}
