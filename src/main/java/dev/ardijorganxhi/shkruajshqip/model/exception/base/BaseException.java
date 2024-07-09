package dev.ardijorganxhi.shkruajshqip.model.exception.base;

import dev.ardijorganxhi.shkruajshqip.model.error.base.BaseErrorMessage;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BaseException extends RuntimeException {
    protected final BaseErrorMessage errorMessage;
}
