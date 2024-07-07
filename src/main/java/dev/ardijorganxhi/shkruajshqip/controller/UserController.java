package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.model.request.UserUpdateRequest;
import dev.ardijorganxhi.shkruajshqip.service.UserService;
import dev.ardijorganxhi.shkruajshqip.utils.IdentityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<GenericResponse<PagingResult<UserDto>>> findAllUsers(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) Sort.Direction direction
    ) {
        final PaginationRequest request = new PaginationRequest(page, size, sortField, direction);
        final PagingResult<UserDto> users = userService.findAllUsers(request);
        return GenericResponse.success(MessageResponse.USER_FOUND, users);
    }

    @GetMapping("/profile")
    public ResponseEntity<GenericResponse<UserDto>> getProfile() {
        final UserDto user = userService.findUserById(IdentityUtils.getUser());
        return GenericResponse.success(MessageResponse.USER_FOUND, user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<UserDto>> findById(@PathVariable("id") Integer id) {
        final UserDto user = userService.findUserById(id);
        return GenericResponse.success(MessageResponse.USER_FOUND, user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> updateById(@PathVariable("id") Integer id, @Valid @RequestBody UserUpdateRequest request) {
        userService.updateUserById(id, request);
        return GenericResponse.success(MessageResponse.USER_UPDATED, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> deleteById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return GenericResponse.success(MessageResponse.USER_DELETED, null);
    }
}
