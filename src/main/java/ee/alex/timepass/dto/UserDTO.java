package ee.alex.timepass.dto;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    private static final long serialVersionUID = -6523450813156118821L;

    @Size(min = 1, max = 25)
    private String firstname;

    @Size(min = 1, max = 25)
    private String lastname;

    @Size(min = 1, max = 25)
    private String midlename;

    private String ssn;

    private List<RoleDTO> roleDTOs;

    private List<CourseDTO> courseDTOs;
}
