package dev.ardijorganxhi.shkruajshqip.model.enums;

public enum MessageResponse {

    REGISTRATION_IS_SUCCESSFUL("Registration is successful"),
    LOGIN_IS_SUCCESSFUL("Login is successful"),
    USER_FOUND("User found"),
    USER_UPDATED("User is updated"),
    USER_DELETED("User is deleted");


    public final String label;

    MessageResponse(String label) {
        this.label = label;
    }
}
