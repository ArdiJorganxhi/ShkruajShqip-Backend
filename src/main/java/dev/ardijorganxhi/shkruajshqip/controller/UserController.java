package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.EntryDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.FollowshipDto;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.UserUpdateRequest;
import dev.ardijorganxhi.shkruajshqip.service.EntryService;
import dev.ardijorganxhi.shkruajshqip.service.FollowshipService;
import dev.ardijorganxhi.shkruajshqip.service.UserService;
import dev.ardijorganxhi.shkruajshqip.utils.IdentityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EntryService entryService;
    private final FollowshipService followshipService;

    @GetMapping
    public ResponseEntity<GenericResponse<PagingResult<UserDto>>> findAllUsers(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) Sort.Direction direction
    ) {
        final PaginationRequest request = new PaginationRequest(page, size, sortField, direction);
        final PagingResult<UserDto> users = userService.findAll(request);
        return GenericResponse.success(MessageResponse.USER_FOUND, users);
    }

    @GetMapping("/profile")
    public ResponseEntity<GenericResponse<UserDto>> getProfile() {
        final UserDto user = userService.findById(IdentityUtils.getUser());
        return GenericResponse.success(MessageResponse.USER_FOUND, user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<UserDto>> findById(@PathVariable("id") Integer id) {
        final UserDto user = userService.findById(id);
        return GenericResponse.success(MessageResponse.USER_FOUND, user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> updateById(@PathVariable("id") Integer id, @Valid @RequestBody UserUpdateRequest request) {
        userService.updateUserById(id, request);
        return GenericResponse.success(MessageResponse.USER_UPDATED, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return GenericResponse.success(MessageResponse.USER_DELETED, null);
    }

    @GetMapping("/{id}/entries")
    public ResponseEntity<GenericResponse<List<EntryDto>>> getEntriesOfUser(@PathVariable("id") Integer id) {
        final List<EntryDto> entries = entryService.findEntriesOfUser(id);
        return GenericResponse.success(MessageResponse.ENTRY_FOUND, entries);
    }

    @PostMapping("/follow/{id}")
    public ResponseEntity<GenericResponse<String>> followUser(@PathVariable("id") Integer id) {
        followshipService.follow(id);
        return GenericResponse.success(MessageResponse.USER_FOLLOWED, null);
    }

    @PostMapping("/unfollow/{id}")
    public ResponseEntity<GenericResponse<String>> unfollowUser(@PathVariable("id") Integer id) {
        followshipService.unfollow(id);
        return GenericResponse.success(MessageResponse.USER_UNFOLLOWED, null);
    }

    @GetMapping("/{id}/followers")
    public ResponseEntity<GenericResponse<List<FollowshipDto>>> getFollowers(@PathVariable("id") Integer id) {
        final List<FollowshipDto> followers = followshipService.getFollowersOfUser(id);
        return GenericResponse.success(MessageResponse.FOLLOWERS_FOUND, followers);
    }

    @GetMapping("/followers")
    public ResponseEntity<GenericResponse<List<FollowshipDto>>> getFollowersOfProfile() {
        final List<FollowshipDto> followers = followshipService.getFollowersOfUser(IdentityUtils.getUser());
        return GenericResponse.success(MessageResponse.FOLLOWERS_FOUND, followers);
    }

    @GetMapping("/{id}/following")
    public ResponseEntity<GenericResponse<List<FollowshipDto>>> getFollowing(@PathVariable("id") Integer id) {
        final List<FollowshipDto> following = followshipService.getFollowingOfUser(id);
        return GenericResponse.success(MessageResponse.FOLLOWING_FOUND, following);
    }

    @GetMapping("/following")
    public ResponseEntity<GenericResponse<List<FollowshipDto>>> getFollowingOfProfile() {
        final List<FollowshipDto> following = followshipService.getFollowingOfUser(IdentityUtils.getUser());
        return GenericResponse.success(MessageResponse.FOLLOWING_FOUND, following);
    }

}
