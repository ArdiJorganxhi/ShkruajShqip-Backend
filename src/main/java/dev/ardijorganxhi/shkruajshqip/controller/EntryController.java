package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.entity.Vote;
import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.TopicDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.VoteDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.enums.VoteType;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.service.EntryService;
import dev.ardijorganxhi.shkruajshqip.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
@RequiredArgsConstructor
public class EntryController {

    private final VoteService voteService;
    private final EntryService entryService;

    @GetMapping
    public ResponseEntity<GenericResponse<PagingResult<EntryDto>>> findAllEntries(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) Sort.Direction direction
    ) {
        final PaginationRequest request = new PaginationRequest(page, size, sortField, direction);
        final PagingResult<EntryDto> topics = entryService.findAll(request);
        return GenericResponse.success(MessageResponse.TOPIC_FOUND, topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EntryDto>> getEntryById(@PathVariable("id") Integer id) {
        final EntryDto entry = entryService.findById(id);
        return GenericResponse.success(MessageResponse.ENTRY_FOUND, entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> deleteEntryById(@PathVariable("id") Integer id) {
        entryService.deleteById(id);
        return GenericResponse.success(MessageResponse.ENTRY_DELETED, null);
    }

    @PostMapping("/{id}/up-vote")
    public ResponseEntity<GenericResponse<String>> createUpVote(@PathVariable("id") Integer id) {
        voteService.saveVote(VoteType.UPVOTE, id);
        return GenericResponse.success(MessageResponse.VOTE_CREATED, null);
    }

    @PostMapping("/{id}/down-vote")
    public ResponseEntity<GenericResponse<String>> createDownVote(@PathVariable("id") Integer id) {
        voteService.saveVote(VoteType.DOWNVOTE, id);
        return GenericResponse.success(MessageResponse.VOTE_CREATED, null);
    }

    @GetMapping("/{id}/up-vote")
    public ResponseEntity<GenericResponse<List<VoteDto>>> getUpvotesOfEntry(@PathVariable("id") Integer id) {
        final List<VoteDto> votes = voteService.findByUpVote(id);
        return GenericResponse.success(MessageResponse.VOTE_FOUND, votes);
    }

    @GetMapping("/{id}/down-vote")
    public ResponseEntity<GenericResponse<List<VoteDto>>> getDownvotesOfEntry(@PathVariable("id") Integer id) {
        final List<VoteDto> votes = voteService.findByDownVote(id);
        return GenericResponse.success(MessageResponse.VOTE_FOUND, votes);
    }
}
