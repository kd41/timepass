package ee.alex.timepass.mapping;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ee.alex.timepass.dto.BaseDTO;
import ee.alex.timepass.entity.BaseEntity;

public abstract class BaseMapper<E extends BaseEntity, D extends BaseDTO>
        implements Mapper<E, D> {

    @Autowired
    ModelMapper modelMapper;

    //Types of entity and DTO classes
    protected Class<E> entityClass;
    protected Class<D> dtoClass;

    public BaseMapper(Class<E> entityClass, Class<D> dtoClass) throws MappingException {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E mapToEntity(D dto) throws MappingException{
        return Objects.isNull(dto)
                ? null
                : modelMapper.map(dto, entityClass);
    }

    @Override
    public D mapToDto(E entity) throws MappingException{
        return Objects.isNull(entity)
                ? null
                : modelMapper.map(entity, dtoClass);
    }

    @Override
    public List<E> mapToListOfEntities(List<D> dtoList) throws MappingException {
        if (!Objects.isNull(dtoList)) {
            return dtoList.stream()
                    .map(dto -> modelMapper.map(dto, entityClass))
                    .collect(Collectors.toList());
        } else return null;
    }

    @Override
    public List<D> mapToListOfDto(List<E> entityList) throws MappingException {
        if (!Objects.isNull(entityList)) {

            return entityList.stream()
                    .map(entity -> modelMapper.map(entity, dtoClass))
                    .collect(Collectors.toList());
        } else return null;
    }
}
