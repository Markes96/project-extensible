package org.mk96.extensible.api.infrastructure.persistence.jpa.repository;

import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MkJpaRepository<EN extends MkEntity, ID> extends JpaRepository<EN, ID> {}
