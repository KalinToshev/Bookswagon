package com.softuni.bookswagon.repository;

import com.softuni.bookswagon.model.entity.RoleEntity;
import com.softuni.bookswagon.model.enums.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRole(RolesEnum roleName);
}