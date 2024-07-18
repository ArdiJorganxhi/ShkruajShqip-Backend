package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.entity.Entry;
import dev.ardijorganxhi.shkruajshqip.entity.Vote;
import dev.ardijorganxhi.shkruajshqip.mapper.VoteMapper;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.VoteDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.VoteType;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.repository.VoteRepository;
import dev.ardijorganxhi.shkruajshqip.service.base.BaseService;
import dev.ardijorganxhi.shkruajshqip.utils.IdentityUtils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService extends BaseService<Vote, VoteDto, VoteRepository, VoteMapper> {

    private final EntryService entryService;

    public VoteService(VoteRepository repository, VoteMapper mapper, EntryService entryService) {
        super(repository, mapper);
        this.entryService = entryService;
    }

    public List<VoteDto> findByUpVote(Integer entryId) {
        final List<Vote> votes = repository.findByVoteAndEntryId(VoteType.UPVOTE, entryId).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("Not found").build()));
        return votes.stream().map(mapper::convertEntityToDto).toList();
    }

    public List<VoteDto> findByDownVote(Integer entryId) {
        final List<Vote> votes = repository.findByVoteAndEntryId(VoteType.DOWNVOTE, entryId).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("Not found").build()));
        return votes.stream().map(mapper::convertEntityToDto).toList();
    }

    @Transactional
    public void saveVote(VoteType voteType, Integer entryId) {
        final EntryDto entry = entryService.findById(entryId);
        final Vote vote = Vote.builder()
                .vote(voteType)
                .entryId(entryId)
                .userId(IdentityUtils.getUser())
                .build();
        save(vote);
    }
}
