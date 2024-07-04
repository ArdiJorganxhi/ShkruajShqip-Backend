package dev.ardijorganxhi.shkruajshqip.controller;

import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.dto.UserDto;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.request.UpdateRequest;
import dev.ardijorganxhi.shkruajshqip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<UserDto>> findById(@PathVariable("id") Integer id) {
        final UserDto user = userService.findUserById(id);
        return GenericResponse.success(MessageResponse.USER_FOUND, user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> updateById(@PathVariable Integer id, @RequestBody UpdateRequest request) {
        userService.updateUserById(id, request);
        return GenericResponse.success(MessageResponse.USER_UPDATED, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<String>> deleteById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return GenericResponse.success(MessageResponse.USER_DELETED, null);
    }
}
