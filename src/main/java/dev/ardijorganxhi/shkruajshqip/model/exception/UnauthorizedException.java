package dev.ardijorganxhi.shkruajshqip.model.exception;

import dev.ardijorganxhi.shkruajshqip.model.exception.base.BaseException;
import dev.ardijorganxhi.shkruajshqip.model.error.base.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends BaseException {
    public UnauthorizedException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
