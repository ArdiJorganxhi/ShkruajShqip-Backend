package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Topic;
import dev.ardijorganxhi.shkruajshqip.model.dto.TopicDto;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {

    public TopicDto convertEntityToDto(Topic topic) {
        return new TopicDto(topic.getId(), topic.getTitle());
    }
}
