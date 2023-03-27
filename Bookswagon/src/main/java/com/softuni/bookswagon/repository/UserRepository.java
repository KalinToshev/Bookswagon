package com.softuni.bookswagon.repository;

import com.softuni.bookswagon.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);

    //Used for unique email validation
    UserEntity findByEmail(String email);

    //Used for unique username validation
    UserEntity findByUsername(String username);
}