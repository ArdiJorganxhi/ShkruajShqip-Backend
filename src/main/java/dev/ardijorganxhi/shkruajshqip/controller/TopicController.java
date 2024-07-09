package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.TopicDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.request.CreateEntryRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.CreateTopicRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.service.EntryService;
import dev.ardijorganxhi.shkruajshqip.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;
    private final EntryService entryService;

    @GetMapping
    public ResponseEntity<GenericResponse<PagingResult<TopicDto>>> findAllTopics(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) Sort.Direction direction
    ) {
        final PaginationRequest request = new PaginationRequest(page, size, sortField, direction);
        final PagingResult<TopicDto> topics = topicService.findAll(request);
        return GenericResponse.success(MessageResponse.TOPIC_FOUND, topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<TopicDto>> getTopicById(@PathVariable("id") Integer id) {
        final TopicDto topic = topicService.findById(id);
        return GenericResponse.success(MessageResponse.TOPIC_FOUND, topic);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<String>> createTopic(@RequestBody CreateTopicRequest request) {
        topicService.createTopic(request);
        return GenericResponse.success(MessageResponse.TOPIC_CREATED, null);
    }

    @PostMapping("/{id}/entries")
    public ResponseEntity<GenericResponse<String>> createEntry(@PathVariable("id") Integer id, @Valid @RequestBody CreateEntryRequest request) {
        entryService.createEntry(request, id);
        return GenericResponse.success(MessageResponse.ENTRY_CREATED, null);
    }

    @GetMapping("/{id}/entries")
    public ResponseEntity<GenericResponse<List<EntryDto>>> getEntriesOfTopic(@PathVariable("id") Integer id) {
        final List<EntryDto> entries = entryService.findEntriesOfTopic(id);
        return GenericResponse.success(MessageResponse.ENTRY_FOUND, entries);
    }


}
