package ee.alex.timepass.mapping;

import ee.alex.timepass.dto.BaseDTO;
import ee.alex.timepass.entity.BaseEntity;

import java.util.List;

public interface Mapper<E extends BaseEntity, D extends BaseDTO> {

    E mapToEntity(D dto);
    D mapToDto(E entity);

    List<E>  mapToListOfEntities(List<D> dtoList);
    List<D> mapToListOfDto(List<E> entityList);
}
