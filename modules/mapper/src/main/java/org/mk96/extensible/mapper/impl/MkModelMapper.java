package org.mk96.extensible.mapper.impl;

import java.util.function.Function;

import org.mk96.common.type.MkObject;
import org.mk96.extensible.mapper.MkMapper;
import org.mk96.extensible.mapper.util.MkMapperUtils;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;

public class MkModelMapper<SRC extends MkObject, DST extends MkObject>
	implements MkMapper<SRC, DST> {

	private final Class<SRC> srcType;
	private final Class<DST> dstType;

	protected final TypeMap<SRC, DST> typeMap;

	/**
	 * This constructor is only for extend classes
	 *
	 * This constructor don't work on inner classes
	 */
	@SuppressWarnings("unchecked")
	protected MkModelMapper() {

		final Class<?>[] rawArguments = MkMapperUtils
				.resolveRawArguments(MkModelMapper.class, this.getClass());

		srcType = (Class<SRC>) rawArguments[0];
		dstType = (Class<DST>) rawArguments[1];

		final ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPreferNestedProperties(false);
		typeMap = mapper.createTypeMap(srcType, dstType);
	}

	public MkModelMapper(
			final Class<SRC> srcType,
			final Class<DST> dstType) {

		this.srcType = srcType;
		this.dstType = dstType;

		final ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPreferNestedProperties(false);
		typeMap = mapper.createTypeMap(srcType, dstType);
	}

	@Override
	public DST map(final SRC source) {
		return typeMap.map(source);
	}

	// =======================================================
	// add mapping by function
	// =======================================================

	public <DSTv> void addMapping(
			final SourceGetter<SRC> getter,
			final DestinationSetter<DST, DSTv> setter) {
		typeMap.addMapping(getter, setter);
	}

	public <SRCv, DSTv> void addMapping(
			final SourceGetter<SRC> getter,
			final DestinationSetter<DST, DSTv> setter,
			final Function<SRCv, DSTv> converter) {
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter);
		typeMap.addMappings(expresion);
	}

	public <SRCv extends MkObject, DSTv extends MkObject> void addMapping(
			final SourceGetter<SRC> getter,
			final DestinationSetter<DST, DSTv> setter,
			final MkMapper<SRCv, DSTv> converter) {
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter::map);
		typeMap.addMappings(expresion);
	}

	// =======================================================
	// add mapping by field names
	// =======================================================

	public void addMapping(
			final String srcFieldName,
			final String dstFieldName) {
		final SourceGetter<SRC> getter = MkMapperUtils.findSrcGetter(srcFieldName, srcType);
		final DestinationSetter<DST, ?> setter = MkMapperUtils.findDstSetter(dstFieldName, dstType);
		typeMap.addMapping(getter, setter);
	}

	public <SRCv, DSTv> void addMapping(
			final String srcFieldName,
			final String dstFieldName,
			final Function<SRCv, DSTv> converter) {
		final SourceGetter<SRC> getter = MkMapperUtils.findSrcGetter(srcFieldName, srcType);
		final DestinationSetter<DST, DSTv> setter = MkMapperUtils.findDstSetter(dstFieldName, dstType);
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter);
		typeMap.addMappings(expresion);
	}

	public <SRCv extends MkObject, DSTv extends MkObject> void addMapping(
			final String srcFieldName,
			final String dstFieldName,
			final MkMapper<SRCv, DSTv> converter) {
		final SourceGetter<SRC> getter = MkMapperUtils.findSrcGetter(srcFieldName, srcType);
		final DestinationSetter<DST, DSTv> setter = MkMapperUtils.findDstSetter(dstFieldName, dstType);
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter::map);
		typeMap.addMappings(expresion);
	}

	// =======================================================
	// add mapping with same field name
	// =======================================================

	public <SRCv, DSTv> void addMapping(
			final String fieldName,
			final Function<SRCv, DSTv> converter) {
		final SourceGetter<SRC> getter = MkMapperUtils.findSrcGetter(fieldName, srcType);
		final DestinationSetter<DST, DSTv> setter = MkMapperUtils.findDstSetter(fieldName, dstType);
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter);
		typeMap.addMappings(expresion);
	}

	public <SRCv extends MkObject, DSTv extends MkObject> void addMapping(
			final String fieldName,
			final MkMapper<SRCv, DSTv> converter) {
		final SourceGetter<SRC> getter = MkMapperUtils.findSrcGetter(fieldName, srcType);
		final DestinationSetter<DST, DSTv> setter = MkMapperUtils.findDstSetter(fieldName, dstType);
		final ExpressionMap<SRC, DST> expresion = MkMapperUtils.createMapping(getter, setter, converter::map);
		typeMap.addMappings(expresion);
	}

}
