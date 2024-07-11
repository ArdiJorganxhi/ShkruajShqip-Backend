package dev.ardijorganxhi.shkruajshqip.model.enums;

import org.springframework.http.HttpStatus;

public enum MessageResponse {

    REGISTRATION_IS_SUCCESSFUL(HttpStatus.CREATED, "Registration is successful"),
    LOGIN_IS_SUCCESSFUL(HttpStatus.OK, "Login is successful"),
    USER_FOUND(HttpStatus.OK, "User found"),
    USER_UPDATED(HttpStatus.OK, "User is updated"),
    USER_DELETED(HttpStatus.OK, "User is deleted"),
    ACCESS_DENIED_ERROR(HttpStatus.FORBIDDEN, "Forbidden"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occured"),
    NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "Not found"),
    BAD_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "Bad Request"),
    ENTRY_FOUND(HttpStatus.OK, "Entry found"),
    TOPIC_FOUND(HttpStatus.OK, "Topic found"),
    TOPIC_CREATED(HttpStatus.CREATED, "Topic created"),
    ENTRY_CREATED(HttpStatus.CREATED, "Entry created"),
    USER_FOLLOWED(HttpStatus.CREATED, "Follow is successful"),
    USER_UNFOLLOWED(HttpStatus.OK, "Unfollow is successful"),
    FOLLOWERS_FOUND(HttpStatus.OK, "Followers found"),
    FOLLOWING_FOUND(HttpStatus.OK, "Following found");


    public final HttpStatus status;
    public final String label;

    MessageResponse(HttpStatus status, String label) {
        this.status = status;
        this.label = label;
    }
}
