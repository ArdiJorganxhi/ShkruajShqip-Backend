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
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService extends BaseService<Topic, TopicDto, TopicRepository, TopicMapper> {

    public TopicService(TopicRepository repository, TopicMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    public void createTopic(CreateTopicRequest request) {
        final Topic topic = Topic.builder()
                .title(request.title())
                .build();
        save(topic);
    }
}
