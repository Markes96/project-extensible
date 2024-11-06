package org.mk96.extensible.api.crud.infrastructure.jpa.repository;

import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MkJpaRepository<EN extends MkEntity, ID>
	extends CrudRepository<EN, ID>,
	JpaSpecificationExecutor<EN> {}
