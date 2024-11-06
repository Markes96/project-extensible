package org.mk96.extensible.api.infrastructure.http.mapper.response.impl;

import java.util.function.Function;
import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkRestResponseModelMapper<DOM extends MkDomain, RES extends MkRestResponseDto>
	implements MkRestResponseMapper<DOM, RES> {

	public final MkModelMapper<DOM, RES> responseMapper;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkRestResponseModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkRestResponseModelMapper.class, this.getClass());

		final Class<DOM> domainType = (Class<DOM>) rawArguments[0];
		final Class<RES> responseType = (Class<RES>) rawArguments[1];

		responseMapper = new MkModelMapper<>(domainType, responseType);

	}

	public MkRestResponseModelMapper(
			final Class<DOM> domainType,
			final Class<RES> responseType) {
		responseMapper = new MkModelMapper<>(domainType, responseType);
	}

	// =======================================================
    // MAPPER
    // =======================================================

	@Override
	public RES map(final DOM domain) {
		return responseMapper.map(domain);
	}

	// =======================================================
	// RESPONSE
	// =======================================================

	public <RESv> void addResponseMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<RES, RESv> setter) {
		responseMapper.addMapping(getter, setter);
	}

	public <DOMv, RESv> void addResponseMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<RES, RESv> setter,
			final Function<DOMv, RESv> converter) {
		responseMapper.addMapping(getter, setter, converter);
	}

	public <DOMv extends MkObject, RESv extends MkObject> void addResponseMapping(
			final SourceGetter<DOM> getter,
			final DestinationSetter<RES, RESv> setter,
			final MkMapper<DOMv, RESv> converter) {
		responseMapper.addMapping(getter, setter, converter);
	}

	public void addResponseMapping(
			final String srcFieldName,
			final String dstFieldName) {
		responseMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <DOMv, RESv> void addResponseMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<DOMv, RESv> converter) {
		responseMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv extends MkObject, RESv extends MkObject> void addResponseMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<DOMv, RESv> converter) {
		responseMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <DOMv, RESv> void addResponseMapping(
			final String fieldName,
			final Function<DOMv, RESv> converter) {
		responseMapper.addMapping(fieldName, converter);
	}

	protected <DOMv extends MkObject, RESv extends MkObject> void addResponseMapping(
			final String fieldName,
			final MkMapper<DOMv, RESv> converter) {
		responseMapper.addMapping(fieldName, converter);
	}

}
