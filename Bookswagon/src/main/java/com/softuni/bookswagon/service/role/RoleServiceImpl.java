package com.softuni.bookswagon.service.role;

import com.softuni.bookswagon.model.entity.RoleEntity;
import com.softuni.bookswagon.model.enums.RolesEnum;
import com.softuni.bookswagon.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) Arrays.stream(RolesEnum.values())
                .forEach(role_ -> {
                    RoleEntity role = new RoleEntity(role_);
                    roleRepository.save(role);
                });
    }
}
