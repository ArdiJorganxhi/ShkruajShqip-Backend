package dev.ardijorganxhi.shkruajshqip.mapper;

import dev.ardijorganxhi.shkruajshqip.entity.Topic;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.TopicDto;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper implements BaseMapper<TopicDto, Topic> {

    public TopicDto convertEntityToDto(Topic topic) {
        return TopicDto.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .createdBy(topic.getCreatedBy())
                .createdOn(topic.getCreatedDate())
                .lastModifiedOn(topic.getLastModifiedDate())
                .lastModifiedBy(topic.getLastModifiedBy())
                .build();
    }
}
