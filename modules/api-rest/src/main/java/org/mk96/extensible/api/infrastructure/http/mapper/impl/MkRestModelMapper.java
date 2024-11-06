package org.mk96.extensible.api.infrastructure.http.mapper.impl;

import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestBodyDto;
import org.mk96.extensible.api.infrastructure.http.dto.MkRestResponseDto;
import org.mk96.extensible.api.infrastructure.http.mapper.MkRestMapper;
import org.mk96.extensible.api.infrastructure.http.mapper.body.MkRestBodyMapper;
import org.mk96.extensible.api.infrastructure.http.mapper.body.impl.MkRestBodyModelMapper;
import org.mk96.extensible.api.infrastructure.http.mapper.response.MkRestResponseMapper;
import org.mk96.extensible.api.infrastructure.http.mapper.response.impl.MkRestResponseModelMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;

import lombok.experimental.Delegate;

public class MkRestModelMapper<BOD extends MkRestBodyDto, DOM extends MkDomain, RES extends MkRestResponseDto>
	implements MkRestMapper<BOD, DOM, RES> {

    @Delegate
	public final MkRestBodyMapper<BOD, DOM> bodyMapper;

    @Delegate
	public final MkRestResponseMapper<DOM, RES> responseMapper;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkRestModelMapper() {
		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkRestModelMapper.class, this.getClass());

		final Class<BOD> bodyType = (Class<BOD>) rawArguments[0];
		final Class<DOM> domainType = (Class<DOM>) rawArguments[1];
		final Class<RES> responseType = (Class<RES>) rawArguments[2];

		bodyMapper = new MkRestBodyModelMapper<>(bodyType, domainType);
		responseMapper = new MkRestResponseModelMapper<>(domainType, responseType);
	}

	protected MkRestModelMapper(
			final Class<BOD> bodyType,
			final Class<DOM> domainType,
			final Class<RES> responseType) {
        bodyMapper = new MkRestBodyModelMapper<>(bodyType, domainType);
        responseMapper = new MkRestResponseModelMapper<>(domainType, responseType);
	}

}
