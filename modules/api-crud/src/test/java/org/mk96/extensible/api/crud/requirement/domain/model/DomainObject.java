package org.mk96.extensible.api.crud.requirement.domain.model;

import org.mk96.extensible.api.domain.model.MkDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainObject extends MkDomain {

	private int i;
	private int j;

}
