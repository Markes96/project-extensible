package org.mk96.extensible.api.crud.infrastructure.jpa.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.mk96.common.util.MkReflectionUtils;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.type.exception.MkCrudException;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MkJpaUtils {

	public Supplier<MkCrudException> buildError(String message) {
		return () -> new MkCrudException(message);
	}

    public <EN extends MkEntity> Specification<EN> buildSpec(final EN entity,
            final Field includeField) {
        return (root, query, cb) -> {
            Path<Object> fieldPath = root.get(includeField.getName());
            Object fieldValue = MkReflectionUtils.getFieldValue(entity, includeField);
            return cb.equal(fieldPath, fieldValue);
        };
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final List<EN> entities,
            final Field includeField) {
        return (root, query, cb) -> {

            Path<Object> fieldPath = root.get(includeField.getName());
            CriteriaBuilder.In<Object> inClause = cb.in(fieldPath);

            for (EN entity : entities) {
                Object fieldValue = MkReflectionUtils.getFieldValue(entity, includeField);
                inClause.value(fieldValue);
            }

            return inClause;
        };
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(final EN entity,
            final List<Field> includeFields) {

        List<Specification<EN>> specs = includeFields.stream()
            .map(field -> buildSpec(entity, field))
            .toList();

        return Specification.allOf(specs);
    }

    public <EN extends MkEntity> Specification<EN> buildSpec(
            Map<EN, List<Field>> includeFieldsByENntity) {

        List<Specification<EN>> specs = includeFieldsByENntity.entrySet().stream()
                .map(fbe -> buildSpec(fbe.getKey(), fbe.getValue()))
                .toList();

        return Specification.anyOf(specs);
    }

}
