package dev.ardijorganxhi.shkruajshqip.model.exception;

import dev.ardijorganxhi.shkruajshqip.model.exception.base.BaseException;
import dev.ardijorganxhi.shkruajshqip.model.error.base.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {
    public NotFoundException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
