package ee.alex.timepass.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class CourseEntity extends BaseEntity {

    @NotBlank
    @Length(min = 1, max = 50)
    private String name;

    @Length(max = 2000)
    private String description;

    @OneToMany(mappedBy = "course")
    private List<UserCourseEntity> userCourses;
}
