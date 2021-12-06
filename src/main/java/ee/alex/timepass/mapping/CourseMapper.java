package ee.alex.timepass.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ee.alex.timepass.dto.CourseDTO;
import ee.alex.timepass.entity.CourseEntity;

@Component
public class CourseMapper extends BaseMapper<CourseEntity, CourseDTO> {

    @Autowired
    public CourseMapper() {
        super(CourseEntity.class, CourseDTO.class);
    }
}
