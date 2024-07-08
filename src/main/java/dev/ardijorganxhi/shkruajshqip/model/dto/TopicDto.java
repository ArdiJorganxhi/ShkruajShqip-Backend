package dev.ardijorganxhi.shkruajshqip.model.dto;

import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto extends BaseDto {
    String title;
}
