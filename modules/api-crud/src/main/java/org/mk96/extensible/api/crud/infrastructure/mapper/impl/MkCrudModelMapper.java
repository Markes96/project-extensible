package org.mk96.extensible.api.crud.infrastructure.mapper.impl;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.crud.infrastructure.dto.MkData;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkCrudModelMapper<DOM extends MkDomain, DATA extends MkData>
	implements MkCrudMapper<DOM, DATA> {

	public final MkModelMapper<DOM, DATA> dataMapper;
	public final MkModelMapper<DATA, DOM> domainMapper;
	public final MkModelMapper<DATA, DATA> dataUpdater;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkCrudModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkCrudModelMapper.class, this.getClass());

		final Class<DOM> domainType = (Class<DOM>) rawArguments[0];
		final Class<DATA> dataType = (Class<DATA>) rawArguments[1];

		dataMapper = new MkModelMapper<>(domainType, dataType);
		domainMapper = new MkModelMapper<>(dataType, domainType);
		dataUpdater = new MkModelMapper<>(dataType, dataType);

	}

	protected MkCrudModelMapper(
			final Class<DOM> domainType,
			final Class<DATA> dataType) {
		dataMapper = new MkModelMapper<>(domainType, dataType);
		domainMapper = new MkModelMapper<>(dataType, domainType);
		dataUpdater = new MkModelMapper<>(dataType, dataType);
	}

	@Override
	public DOM map(final DATA data) {
		return domainMapper.map(data);
	}

	@Override
	public DATA map(final DOM domain) {
		return dataMapper.map(domain);
	}
	
	@Override
	public DATA update(DATA data) {
		return dataUpdater.map(data);
	}
	
	// =======================================================
	// data
	// =======================================================

	public <ENv> void adddataMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<DATA, ENv> setter) {
		dataMapper.addMapping(getter, setter);
	}

	public <DOMv, ENv> void adddataMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<DATA, ENv> setter,
			final Function<DOMv, ENv> converter) {
		dataMapper.addMapping(getter, setter, converter);
	}

	public <DOMv extends MkObject, ENv extends MkObject> void adddataMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<DATA, ENv> setter,
			final MkMapper<DOMv, ENv> converter) {
		dataMapper.addMapping(getter, setter, converter);
	}

	public void adddataMapping(
			final String srcFieldName,
			final String dstFieldName) {
		dataMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <DOMv, ENv> void adddataMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<DOMv, ENv> converter) {
		dataMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv extends MkObject, ENv extends MkObject> void adddataMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<DOMv, ENv> converter) {
		dataMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv, ENv> void adddataMapping(
			final String fieldName,
			final Function<DOMv, ENv> converter) {
		dataMapper.addMapping(fieldName, converter);
	}

	protected <DOMv extends MkObject, ENv extends MkObject> void adddataMapping(
			final String fieldName,
			final MkMapper<DOMv, ENv> converter) {
		dataMapper.addMapping(fieldName, converter);
	}

	// =======================================================
    // Domain
	// =======================================================

	public <DOMv> void addDomainMapping(
			final SourceGetter<DATA> getter,
			final DestinationSetter<DOM, DOMv> setter) {
		domainMapper.addMapping(getter, setter);
	}

	public <ENv, DOMv> void addDomainMapping(
			final SourceGetter<DATA> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final Function<ENv, DOMv> converter) {
		domainMapper.addMapping(getter, setter, converter);
	}

	public <ENv extends MkObject, DOMv extends MkObject> void addDomainMapping(
			final SourceGetter<DATA> getter,
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
