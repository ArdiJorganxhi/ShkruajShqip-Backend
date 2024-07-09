package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.mapper.EntryMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.model.request.CreateEntryRequest;
import dev.ardijorganxhi.shkruajshqip.repository.EntryRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import dev.ardijorganxhi.shkruajshqip.utils.IdentityUtils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService extends BaseService<Entry, EntryDto, EntryRepository, EntryMapper> {

    public EntryService(EntryRepository repository, EntryMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    public void createEntry(CreateEntryRequest request, Integer topicId) {
        final Entry entry = Entry.builder()
                .content(request.content())
                .topicId(topicId)
                .userId(IdentityUtils.getUser())
                .build();
        save(entry);
    }

    public List<EntryDto> findEntriesOfTopic(Integer topicId) {
        final List<Entry> entries = repository.findByTopicId(topicId).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("Entry not found").build()));
        return entries.stream().map(mapper::convertEntityToDto).toList();
    }

    public List<EntryDto> findEntriesOfUser(Integer userId) {
        final List<Entry> entries = repository.findByUserId(userId).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("Entry not found").build()));
        return entries.stream().map(mapper::convertEntityToDto).toList();
    }
}
