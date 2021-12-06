package ee.alex.timepass.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @NotBlank
    @Length(min = 1, max = 25)
    private String firstname;

    @NotNull
    @Length(min = 1, max = 25)
    private String lastname;

    @Length(min = 1, max = 25)
    private String midlename;

    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<UserRoleEntity> userRoles;

    @OneToMany(mappedBy = "user")
    private List<UserCourseEntity> userCourses;

}
