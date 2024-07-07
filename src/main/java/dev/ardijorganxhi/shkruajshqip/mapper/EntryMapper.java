package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper {

    public EntryDto convertEntityToDto(Entry entry) {
        return new EntryDto(entry.getId(), entry.getContent(), entry.getUser().getUsername());
    }
}
