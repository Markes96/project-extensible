package org.mk96.extensible.api.infrastructure.persistence.mapper.impl;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.persistence.mapper.MkPersistenceMapper;
import org.mk96.extensible.api.infrastructure.persistence.type.MkEntity;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkPersistenceModelMapper<DOM extends MkDomain, EN extends MkEntity>
	implements MkPersistenceMapper<DOM, EN> {

	public final MkModelMapper<DOM, EN> entityMapper;
	public final MkModelMapper<EN, DOM> domainMapper;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkPersistenceModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkPersistenceModelMapper.class, this.getClass());

		final Class<DOM> domainType = (Class<DOM>) rawArguments[0];
		final Class<EN> entityType = (Class<EN>) rawArguments[1];

		entityMapper = new MkModelMapper<>(domainType, entityType);
		domainMapper = new MkModelMapper<>(entityType, domainType);

	}

	protected MkPersistenceModelMapper(
			final Class<DOM> domainType,
			final Class<EN> entityType) {
		entityMapper = new MkModelMapper<>(domainType, entityType);
		domainMapper = new MkModelMapper<>(entityType, domainType);
	}

	@Override
	public DOM map(final EN entity) {
		return domainMapper.map(entity);
	}

	@Override
	public EN map(final DOM domain) {
		return entityMapper.map(domain);
	}
	
	// =======================================================
	// Entity
	// =======================================================

	public <ENv> void addEntityMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<EN, ENv> setter) {
		entityMapper.addMapping(getter, setter);
	}

	public <DOMv, ENv> void addEntityMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<EN, ENv> setter,
			final Function<DOMv, ENv> converter) {
		entityMapper.addMapping(getter, setter, converter);
	}

	public <DOMv extends MkObject, ENv extends MkObject> void addEntityMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<EN, ENv> setter,
			final MkMapper<DOMv, ENv> converter) {
		entityMapper.addMapping(getter, setter, converter);
	}

	public void addEntityMapping(
			final String srcFieldName,
			final String dstFieldName) {
		entityMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <DOMv, ENv> void addEntityMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<DOMv, ENv> converter) {
		entityMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv extends MkObject, ENv extends MkObject> void addEntityMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<DOMv, ENv> converter) {
		entityMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv, ENv> void addEntityMapping(
			final String fieldName,
			final Function<DOMv, ENv> converter) {
		entityMapper.addMapping(fieldName, converter);
	}

	protected <DOMv extends MkObject, ENv extends MkObject> void addEntityMapping(
			final String fieldName,
			final MkMapper<DOMv, ENv> converter) {
		entityMapper.addMapping(fieldName, converter);
	}

	// =======================================================
    // Domain
	// =======================================================

	public <DOMv> void addDomainMapping(
			final SourceGetter<EN> getter,
			final DestinationSetter<DOM, DOMv> setter) {
		domainMapper.addMapping(getter, setter);
	}

	public <ENv, DOMv> void addDomainMapping(
			final SourceGetter<EN> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final Function<ENv, DOMv> converter) {
		domainMapper.addMapping(getter, setter, converter);
	}

	public <ENv extends MkObject, DOMv extends MkObject> void addDomainMapping(
			final SourceGetter<EN> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final MkMapper<ENv, DOMv> converter) {
		domainMapper.addMapping(getter, setter, converter);
	}

	public void addDomainMapping(
			final String srcFieldName,
			final String dstFieldName) {
		domainMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <ENv, DOMv> void addDomainMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<ENv, DOMv> converter) {
		domainMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <ENv extends MkObject, DOMv extends MkObject> void addDomainMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<ENv, DOMv> converter) {
		domainMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <ENv, DOMv> void addDomainMapping(
			final String fieldName,
			final Function<ENv, DOMv> converter) {
		domainMapper.addMapping(fieldName, converter);
	}

	protected <ENv extends MkObject, DOMv extends MkObject> void addDomainMapping(
			final String fieldName,
			final MkMapper<ENv, DOMv> converter) {
		domainMapper.addMapping(fieldName, converter);
	}

}
