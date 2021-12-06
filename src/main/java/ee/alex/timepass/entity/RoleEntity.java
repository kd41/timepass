package ee.alex.timepass.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    @NotBlank
    @Length(min = 1, max = 25)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<UserRoleEntity> userRoles;
}
