package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.mapper.EntryMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.repository.EntryRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService extends BaseService<Entry, EntryDto, EntryRepository, EntryMapper> {

    public EntryService(EntryRepository repository, EntryMapper mapper) {
        super(repository, mapper);
    }

    public List<EntryDto> findEntriesOfTopic(Integer topicId) {
        final List<Entry> entries = repository.findByTopicId(topicId).orElseThrow();
        return entries.stream().map(mapper::convertEntityToDto).toList();
    }
}
