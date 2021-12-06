package ee.alex.timepass.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ee.alex.timepass.dto.BaseCreatedDTO;
import ee.alex.timepass.dto.BaseDTO;
import ee.alex.timepass.dto.CourseDTO;
import ee.alex.timepass.dto.RoleDTO;
import ee.alex.timepass.dto.UserCourseDTO;
import ee.alex.timepass.dto.UserDTO;
import ee.alex.timepass.dto.UserRoleDTO;
import ee.alex.timepass.entity.BaseCreatedEntity;
import ee.alex.timepass.entity.BaseEntity;
import ee.alex.timepass.entity.CourseEntity;
import ee.alex.timepass.entity.RoleEntity;
import ee.alex.timepass.entity.UserCourseEntity;
import ee.alex.timepass.entity.UserEntity;
import ee.alex.timepass.entity.UserRoleEntity;

public class EntityToDTOConverter {

    private EntityToDTOConverter() {
        // empty
    }

    // List<UserDTO>
    public static List<UserDTO> convertUserEntities(List<UserEntity> entities) {
        List<UserDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertUserEntity(entity));
        });
        return list;
    }

    // UserDTO
    public static UserDTO convertUserEntity(UserEntity entity) {
        UserDTO dto = new UserDTO();
        convertBaseEntity(dto, entity);
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setMidlename(entity.getMidlename());
        dto.setSsn(entity.getSsn());
        dto.setRoleDTOs(convertRoleEntities2(entity.getUserRoles()));
        dto.setCourseDTOs(convertCourseEntities2(entity.getUserCourses()));
        return dto;
    }

    // UserDTO
    public static UserDTO convertUserEntity2(UserEntity entity) {
        UserDTO dto = new UserDTO();
        convertBaseEntity(dto, entity);
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setMidlename(entity.getMidlename());
        dto.setSsn(entity.getSsn());
        return dto;
    }

    // List<RoleDTO>
    public static List<RoleDTO> convertRoleEntities(List<RoleEntity> entities) {
        List<RoleDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertRoleEntity(entity));
        });
        return list;
    }

    // List<CourseDTO>
    public static List<CourseDTO> convertCourseEntities(List<CourseEntity> entities) {
        List<CourseDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertCourseEntity(entity));
        });
        return list;
    }

    // CourseDTO
    public static CourseDTO convertCourseEntity(CourseEntity entity) {
        CourseDTO dto = new CourseDTO();
        convertBaseEntity(dto, entity);
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setUserDTOs(convertUserEntities2(entity.getUserCourses()));
        return dto;
    }

    // List<RoleDTO>
    public static List<RoleDTO> convertRoleEntities2(List<UserRoleEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        List<RoleDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertRoleEntity(entity.getRole()));
        });
        return list;
    }

    // List<CourseDTO>
    public static List<CourseDTO> convertCourseEntities2(List<UserCourseEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        List<CourseDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertCourseEntity(entity.getCourse()));
        });
        return list;
    }

    // RoleDTO
    public static RoleDTO convertRoleEntity(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        convertBaseEntity(dto, entity);
        dto.setName(entity.getName());
        return dto;
    }

    // List<UserRoleDTO>
    public static List<UserRoleDTO> convertUserRoleEntities(List<UserRoleEntity> entities) {
        List<UserRoleDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertUserRoleEntity(entity));
        });
        return list;
    }

    // UserRoleDTO
    public static UserRoleDTO convertUserRoleEntity(UserRoleEntity entity) {
        UserRoleDTO dto = new UserRoleDTO();
        convertBaseCreatedEntity(dto, entity);
        dto.setUserId(entity.getUser()
                .getId());
        dto.setRoleId(entity.getRole()
                .getId());
        return dto;
    }

    // List<UserCourseDTO>
    public static List<UserCourseDTO> convertUserCourseEntities(List<UserCourseEntity> entities) {
        List<UserCourseDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertUserCourseEntity(entity));
        });
        return list;
    }

    // UserCourseDTO
    public static UserCourseDTO convertUserCourseEntity(UserCourseEntity entity) {
        UserCourseDTO dto = new UserCourseDTO();
        convertBaseCreatedEntity(dto, entity);
        dto.setUserId(entity.getUser()
                .getId());
        dto.setCourseId(entity.getCourse()
                .getId());
        return dto;
    }

    // List<UserDTO>
    public static List<UserDTO> convertUserEntities2(List<UserCourseEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        List<UserDTO> list = new ArrayList<>();
        entities.forEach(entity -> {
            list.add(convertUserEntity2(entity.getUser()));
        });
        return list;
    }

    private static void convertBaseEntity(BaseDTO dto, BaseEntity entity) {
        dto.setId(entity.getId());
        dto.setVersion(entity.getVersion());
    }

    private static void convertBaseCreatedEntity(BaseCreatedDTO dto, BaseCreatedEntity entity) {
        convertBaseEntity(dto, entity);
        dto.setCreated(entity.getCreated());
        dto.setUpdated(entity.getUpdated());
    }
}
