package ee.alex.timepass.dto;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO extends BaseDTO {
    private static final long serialVersionUID = 8214163406829882371L;

    @Size(min = 1, max = 25)
    private String name;

    @Size(max = 2000)
    private String description;

    private List<UserDTO> userDTOs;
}
