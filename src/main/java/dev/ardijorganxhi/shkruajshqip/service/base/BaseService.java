package dev.ardijorganxhi.shkruajshqip.service.base;

import dev.ardijorganxhi.shkruajshqip.entity.base.BaseEntity;
import dev.ardijorganxhi.shkruajshqip.mapper.base.BaseMapper;
import dev.ardijorganxhi.shkruajshqip.model.PagingResult;
import dev.ardijorganxhi.shkruajshqip.model.dto.base.BaseDto;
import dev.ardijorganxhi.shkruajshqip.model.error.GenericErrorMessage;
import dev.ardijorganxhi.shkruajshqip.model.exception.NotFoundException;
import dev.ardijorganxhi.shkruajshqip.model.request.PaginationRequest;
import dev.ardijorganxhi.shkruajshqip.utils.PaginationUtils;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Getter
@MappedSuperclass
@RequiredArgsConstructor
public abstract class BaseService<E extends BaseEntity, D extends BaseDto, R extends JpaRepository<E, Integer>, M extends BaseMapper<D, E>> {

    protected final R repository;
    protected final M mapper;

    public void save(E entity) {
        repository.save(entity);
    }

    public D findById(Integer id) {
        E entity = repository.findById(id).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("User not found").build()));
        return mapper.convertEntityToDto(entity);
    }

    public PagingResult<D> findAll(PaginationRequest request) {
        final Pageable pageable = PaginationUtils.getPageable(request.getPage(), request.getSize(), request.getDirection(), request.getSortField());
        final Page<E> entities = repository.findAll(pageable);
        final List<D> entitiesDto = entities.stream().map(mapper::convertEntityToDto).toList();
        return new PagingResult<>(
                entitiesDto,
                entities.getTotalPages(),
                entities.getTotalElements(),
                entities.getSize(),
                entities.getNumber(),
                entities.isEmpty()
        );
    }

    public void deleteById(Integer id) {
        E entity = repository.findById(id).orElseThrow(() -> new NotFoundException(GenericErrorMessage.builder().message("User not found").build()));
        entity.setActive(false);
        save(entity);
    }
}
