package dev.ardijorganxhi.shkruajshqip.model.dto.base;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {

    private Integer id;
    private Date createdOn;
    private String createdBy;
    private Date lastModifiedOn;
    private String lastModifiedBy;
}
