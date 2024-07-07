package dev.ardijorganxhi.shkruajshqip.model.enums;

import org.springframework.http.HttpStatus;

public enum MessageResponse {

    REGISTRATION_IS_SUCCESSFUL(HttpStatus.CREATED, "Registration is successful"),
    LOGIN_IS_SUCCESSFUL(HttpStatus.OK, "Login is successful"),
    USER_FOUND(HttpStatus.OK, "User found"),
    USER_UPDATED(HttpStatus.OK, "User is updated"),
    USER_DELETED(HttpStatus.OK, "User is deleted");


    public final HttpStatus status;
    public final String label;

    MessageResponse(HttpStatus status, String label) {
        this.status = status;
        this.label = label;
    }
}
