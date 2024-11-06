package org.mk96.extensible.api.crud.application.delete.filter.all;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.filter.all.MkDeleteAllByFilterPort;
import org.mk96.extensible.api.crud.domain.service.delete.filter.all.MkDeleteAllByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteAllByFilterUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteAllByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkDeleteAllByFilterPort<DOM> port;
	
}
