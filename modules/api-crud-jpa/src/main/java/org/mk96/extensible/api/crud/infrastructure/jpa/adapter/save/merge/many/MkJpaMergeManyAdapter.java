package org.mk96.extensible.api.crud.infrastructure.jpa.adapter.save.merge.many;

import java.util.List;
import org.mk96.extensible.api.crud.domain.port.save.merge.many.MkMergeManyPort;
import org.mk96.extensible.api.crud.infrastructure.dto.data.MkEntity;
import org.mk96.extensible.api.crud.infrastructure.jpa.repository.MkJpaRepository;
import org.mk96.extensible.api.crud.infrastructure.jpa.util.MkJpaFilterUtils;
import org.mk96.extensible.api.crud.infrastructure.mapper.MkCrudMapper;
import org.mk96.extensible.api.crud.type.save.safe.merge.MkMergeSave;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.adapter.AbstractMkAdapter;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MkJpaMergeManyAdapter<DOM extends MkDomain, EN extends MkEntity, ID>
    extends AbstractMkAdapter<DOM>
    implements MkMergeManyPort<DOM> {

    @Autowired(required = false)
    private MkJpaRepository<EN, ID> repository;

    @Autowired(required = false)
    private MkCrudMapper<DOM, EN> mapper;

    private final ModelMapper updaterMapper = new ModelMapper();

    {
        updaterMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setPropertyCondition(Conditions.isNotNull());
    }

    @Override
    @Transactional
    public List<DOM> mergeMany(MkMergeSave<DOM> domMerge) {

        MkMergeSave<EN> enMerge = domMerge.map(mapper::map);
        Specification<EN> enSpec = MkJpaFilterUtils.buildSpec(enMerge.getFilter());
        List<EN> ensToMerge = repository.findAll(enSpec);

        ensToMerge.forEach(enToMerge -> updaterMapper.map(enMerge.getSave(), enToMerge));

        List<EN> ensMerged = repository.saveAll(ensToMerge);
        return ensMerged.stream().map(mapper::map).toList();
    }

}
