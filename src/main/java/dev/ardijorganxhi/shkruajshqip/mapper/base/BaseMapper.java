package dev.ardijorganxhi.shkruajshqip.mapper.base;

import dev.ardijorganxhi.shkruajshqip.entity.base.BaseEntity;
import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;

public interface BaseMapper<D extends BaseDto, E extends BaseEntity> {

    D convertEntityToDto(E entity);
}
