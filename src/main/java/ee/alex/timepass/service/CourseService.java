package ee.alex.timepass.service;

import java.util.List;

import ee.alex.timepass.dto.CourseDTO;

public interface CourseService {

    void addCourse(CourseDTO courseDTO);

    List<CourseDTO> getAll();

    CourseDTO getById(Long id) throws DataAcessException;
}
