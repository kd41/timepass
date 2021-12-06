package ee.alex.timepass.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ee.alex.timepass.dto.UserDTO;
import ee.alex.timepass.entity.UserEntity;

@Component
public class UserMapper extends BaseMapper<UserEntity, UserDTO> {

	@Autowired
	public UserMapper() {
		super(UserEntity.class, UserDTO.class);
	}
}
