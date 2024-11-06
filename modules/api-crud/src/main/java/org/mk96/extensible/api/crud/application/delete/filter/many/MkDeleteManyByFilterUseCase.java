package org.mk96.extensible.api.crud.application.delete.filter.many;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.delete.filter.many.MkDeleteManyByFilterPort;
import org.mk96.extensible.api.crud.domain.service.delete.filter.many.MkDeleteManyByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkDeleteManyByFilterUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkDeleteManyByFilterService<DOM> {
	
	@Delegate
	@Autowired
	private MkDeleteManyByFilterPort<DOM> port;
	
}
