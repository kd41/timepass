package ee.alex.timepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.alex.timepass.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
