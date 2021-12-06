package ee.alex.timepass.service;

import java.util.List;

import ee.alex.timepass.dto.UserDTO;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> getAll();

    UserDTO getById(Long id) throws DataAcessException;
}
