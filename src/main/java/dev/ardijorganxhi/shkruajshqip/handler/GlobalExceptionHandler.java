package dev.ardijorganxhi.shkruajshqip.handler;

import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.model.exception.base.BaseException;
import dev.ardijorganxhi.shkruajshqip.model.GenericResponse;
import dev.ardijorganxhi.shkruajshqip.model.enums.MessageResponse;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public final ResponseEntity<GenericResponse<GenericErrorMessage>> handleBaseException(BaseException e, WebRequest request) {
        String message = e.getErrorMessage().getMessage();
        String description = request.getDescription(false);

        GenericErrorMessage genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description, request.getContextPath());

        return GenericResponse.error(MessageResponse.INTERNAL_SERVER_ERROR, genericErrorMessage);
    }

    @ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<GenericResponse<GenericErrorMessage>> handleNotFoundException(NotFoundException e, WebRequest request) {
        String message = e.getErrorMessage().getMessage();
        String description = request.getDescription(false);

        GenericErrorMessage genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description, request.getContextPath());

        return GenericResponse.error(MessageResponse.NOT_FOUND_ERROR, genericErrorMessage);
    }
}
