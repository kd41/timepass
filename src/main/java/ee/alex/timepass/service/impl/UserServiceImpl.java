package ee.alex.timepass.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ee.alex.timepass.common.EntityToDTOConverter;
import ee.alex.timepass.dto.UserDTO;
import ee.alex.timepass.entity.UserEntity;
import ee.alex.timepass.mapping.UserMapper;
import ee.alex.timepass.repository.UserRepository;
import ee.alex.timepass.service.DataAcessException;
import ee.alex.timepass.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void addUser(UserDTO userDTO) {
        UserEntity userEntity = mapper.mapToEntity(userDTO);
        repository.save(userEntity);
    }

    public List<UserDTO> getAll() {
        List<UserEntity> entities = repository.findAll();
        return EntityToDTOConverter.convertUserEntities(entities);
    }

    public UserDTO getById(Long id) throws DataAcessException {
        UserEntity entity = repository.getOne(id);
        return EntityToDTOConverter.convertUserEntity(entity);
    }

}
