package org.mk96.extensible.api.infrastructure.http.mapper.body.impl;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.mapper.body.MkRestBodyMapper;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkRestBodyModelMapper<BOD extends MkRestBodyDto, DOM extends MkDomain>
	implements MkRestBodyMapper<BOD, DOM> {

	public final MkModelMapper<BOD, DOM> bodyMapper;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkRestBodyModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkRestBodyModelMapper.class, this.getClass());

		final Class<BOD> bodyType = (Class<BOD>) rawArguments[0];
		final Class<DOM> domainType = (Class<DOM>) rawArguments[1];

		bodyMapper = new MkModelMapper<>(bodyType, domainType);
	}

	public MkRestBodyModelMapper(
			final Class<BOD> bodyType,
			final Class<DOM> domainType) {
		bodyMapper = new MkModelMapper<>(bodyType, domainType);
	}

	// =======================================================
    // MAPPER
    // =======================================================

	@Override
	public DOM map(final BOD body) {
		return bodyMapper.map(body);
	}

	// =======================================================
	// MAPINGS
	// =======================================================

	public <DOMv> void addBodyMapping(
			final SourceGetter<BOD> getter,
			final DestinationSetter<DOM, DOMv> setter) {
		bodyMapper.addMapping(getter, setter);
	}

	public <BODv, DOMv> void addBodyMapping(
			final SourceGetter<BOD> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final Function<BODv, DOMv> converter) {
		bodyMapper.addMapping(getter, setter, converter);
	}

	public <BODv extends MkObject, DOMv extends MkObject> void addBodyMapping(
			final SourceGetter<BOD> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final MkMapper<BODv, DOMv> converter) {
		bodyMapper.addMapping(getter, setter, converter);
	}

	public void addBodyMapping(
			final String srcFieldName,
			final String dstFieldName) {
		bodyMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <BODv, DOMv> void addBodyMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<BODv, DOMv> converter) {
		bodyMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <BODv extends MkObject, DOMv extends MkObject> void addBodyMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<BODv, DOMv> converter) {
		bodyMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <BODv, DOMv> void addBodyMapping(
			final String fieldName,
			final Function<BODv, DOMv> converter) {
		bodyMapper.addMapping(fieldName, converter);
	}

	protected <BODv extends MkObject, DOMv extends MkObject> void addBodyMapping(
			final String fieldName,
			final MkMapper<BODv, DOMv> converter) {
		bodyMapper.addMapping(fieldName, converter);
	}

}
