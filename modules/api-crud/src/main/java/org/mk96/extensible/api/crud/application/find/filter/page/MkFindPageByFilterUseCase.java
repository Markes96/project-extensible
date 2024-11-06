package org.mk96.extensible.api.crud.application.find.filter.page;

import org.mk96.extensible.api.application.AbstractMkUseCase;
import org.mk96.extensible.api.crud.domain.port.find.filter.page.MkFindPageByFilterPort;
import org.mk96.extensible.api.crud.domain.service.find.filter.page.MkFindPageByFilterService;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkFindPageByFilterUseCase<DOM extends MkDomain>
	extends AbstractMkUseCase<DOM>
	implements MkFindPageByFilterService<DOM> {

	@Delegate
	@Autowired(required = false)
	private MkFindPageByFilterPort<DOM> port;

}
