package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Vote;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.VoteDto;
import org.springframework.stereotype.Component;

@Component
public class VoteMapper implements BaseMapper<VoteDto, Vote> {


    public VoteDto convertEntityToDto(Vote entity) {
        return VoteDto.builder()
                .id(entity.getId())
                .vote(entity.getVote())
                .user(entity.getUser().getUsernameOfUser())
                .entry(entity.getEntry().getContent())
                .createdBy(entity.getCreatedBy())
                .createdOn(entity.getCreatedDate())
                .lastModifiedBy(entity.getLastModifiedBy())
                .lastModifiedOn(entity.getLastModifiedDate())
                .build();
    }
}
