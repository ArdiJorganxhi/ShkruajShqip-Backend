package dev.ardijorganxhi.shkruajshqip.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;

import static dev.ardijorganxhi.shkruajshqip.utils.MdcConstant.X_USER_ID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdentityUtils {

    public static Integer getUser() {
        return Integer.valueOf(MDC.get(X_USER_ID));
    }
}
