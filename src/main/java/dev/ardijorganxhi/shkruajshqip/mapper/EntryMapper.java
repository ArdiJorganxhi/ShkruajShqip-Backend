package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper implements BaseMapper<EntryDto, Entry> {

    public EntryDto convertEntityToDto(Entry entry) {
        return EntryDto.builder()
                .id(entry.getId())
                .content(entry.getContent())
                .username(entry.getUser().getUsernameOfUser())
                .createdBy(entry.getCreatedBy())
                .createdOn(entry.getCreatedDate())
                .lastModifiedOn(entry.getLastModifiedDate())
                .lastModifiedBy(entry.getLastModifiedBy())
                .build();
    }
}
