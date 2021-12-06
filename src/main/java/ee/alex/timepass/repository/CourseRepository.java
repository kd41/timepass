package ee.alex.timepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.alex.timepass.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
