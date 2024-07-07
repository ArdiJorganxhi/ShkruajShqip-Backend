package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.entity.Topic;
import dev.ardijorganxhi.shkruajshqip.mapper.EntryMapper;
import dev.ardijorganxhi.shkruajshqip.mapper.TopicMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.TopicDto;
import dev.ardijorganxhi.shkruajshqip.model.request.CreateTopicRequest;
import dev.ardijorganxhi.shkruajshqip.repository.EntryRepository;
import dev.ardijorganxhi.shkruajshqip.repository.TopicRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final EntryRepository entryRepository;
    private final EntryMapper entryMapper;

    @Transactional
    public void createTopic(CreateTopicRequest request) {
        final Topic topic = Topic.builder()
                .title(request.title())
                .build();
        topicRepository.save(topic);
    }

    public TopicDto findTopicById(Integer id) {
        final Topic topic = topicRepository.findById(id).orElseThrow();
        return topicMapper.convertEntityToDto(topic);
    }

    public List<EntryDto> findEntriesOfTopic(Integer topicId) {
        final List<Entry> entries = entryRepository.findByTopicId(topicId).orElseThrow();
        return entries.stream().map(entryMapper::convertEntityToDto).toList();
    }

    public void deleteTopicById(Integer topicId) {
        Topic topic = topicRepository.findById(topicId).orElseThrow();
        topic.setActive(false);
        topicRepository.save(topic);
    }
}
