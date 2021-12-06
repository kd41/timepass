package ee.alex.timepass.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCourseDTO extends BaseCreatedDTO {
    private static final long serialVersionUID = 2772532164451289047L;

    @NotNull
    private Long userId;

    @NotNull
    private Long courseId;

}
