package org.mk96.extensible.api.infrastructure.http.mapper.impl;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRequestDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkControllerMapper;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.impl.MkModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkControllerModelMapper<REQ extends MkRequestDto, DOM extends MkDomain, RES extends MkResponseDto>
	implements MkControllerMapper<REQ, DOM, RES> {

	public final MkModelMapper<REQ, DOM> requestMapper;
	public final MkModelMapper<DOM, RES> responseMapper;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkControllerModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkControllerModelMapper.class, this.getClass());

		final Class<REQ> requestType = (Class<REQ>) rawArguments[0];
		final Class<DOM> domainType = (Class<DOM>) rawArguments[1];
		final Class<RES> responseType = (Class<RES>) rawArguments[2];

		requestMapper = new MkModelMapper<>(requestType, domainType);
		responseMapper = new MkModelMapper<>(domainType, responseType);

	}

	protected MkControllerModelMapper(
			final Class<REQ> requestType,
			final Class<DOM> domainType,
			final Class<RES> responseType) {
		requestMapper = new MkModelMapper<>(requestType, domainType);
		responseMapper = new MkModelMapper<>(domainType, responseType);
	}

	@Override
	public DOM map(final REQ request) {
		return requestMapper.map(request);
	}

	@Override
	public RES map(final DOM domain) {
		return responseMapper.map(domain);
	}

	// =======================================================
	// Request
	// =======================================================

	public <DOMv> void addRequestMapping(
			final SourceGetter<REQ> getter,
			final DestinationSetter<DOM, DOMv> setter) {
		requestMapper.addMapping(getter, setter);
	}

	public <REQv, DOMv> void addRequestMapping(
			final SourceGetter<REQ> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final Function<REQv, DOMv> converter) {
		requestMapper.addMapping(getter, setter, converter);
	}

	public <REQv extends MkObject, DOMv extends MkObject> void addRequestMapping(
			final SourceGetter<REQ> getter,
			final DestinationSetter<DOM, DOMv> setter,
			final MkMapper<REQv, DOMv> converter) {
		requestMapper.addMapping(getter, setter, converter);
	}

	public void addRequestMapping(
			final String srcFieldName,
			final String dstFieldName) {
		requestMapper.addMapping(srcFieldName, dstFieldName);
	}

	public <REQv, DOMv> void addRequestMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<REQv, DOMv> converter) {
		requestMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <REQv extends MkObject, DOMv extends MkObject> void addRequestMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<REQv, DOMv> converter) {
		requestMapper.addMapping(srcFieldName, dstFieldName, converter);
	}

	public <REQv, DOMv> void addRequestMapping(
			final String fieldName,
			final Function<REQv, DOMv> converter) {
		requestMapper.addMapping(fieldName, converter);
	}

	protected <REQv extends MkObject, DOMv extends MkObject> void addRequestMapping(
			final String fieldName,
			final MkMapper<REQv, DOMv> converter) {
		requestMapper.addMapping(fieldName, converter);
	}

	// =======================================================
	// Response
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
