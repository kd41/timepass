package ee.alex.timepass.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ee.alex.timepass.common.EntityToDTOConverter;
import ee.alex.timepass.dto.CourseDTO;
import ee.alex.timepass.entity.CourseEntity;
import ee.alex.timepass.mapping.CourseMapper;
import ee.alex.timepass.repository.CourseRepository;
import ee.alex.timepass.service.CourseService;
import ee.alex.timepass.service.DataAcessException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    public void addCourse(CourseDTO courseDTO) {
        CourseEntity userEntity = mapper.mapToEntity(courseDTO);
        repository.save(userEntity);
    }

    public List<CourseDTO> getAll() {
        List<CourseEntity> entities = repository.findAll();
        return EntityToDTOConverter.convertCourseEntities(entities);
    }

    public CourseDTO getById(Long id) throws DataAcessException {
        CourseEntity entity = repository.getOne(id);
        return EntityToDTOConverter.convertCourseEntity(entity);
    }

}
