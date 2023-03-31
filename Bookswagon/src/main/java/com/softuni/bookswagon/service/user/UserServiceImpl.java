package com.softuni.bookswagon.service.user;

import com.softuni.bookswagon.model.dto.RegisterUserEntityDTO;
import com.softuni.bookswagon.model.dto.UserProfileDetailsDTO;
import com.softuni.bookswagon.model.entity.RoleEntity;
import com.softuni.bookswagon.model.entity.UserEntity;
import com.softuni.bookswagon.model.enums.RolesEnum;
import com.softuni.bookswagon.repository.RoleRepository;
import com.softuni.bookswagon.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterUserEntityDTO registerUserEntityDTO) {
        UserEntity userEntity = new UserEntity();

        modelMapper.map(registerUserEntityDTO, userEntity);

        userEntity.setPassword(passwordEncoder.encode(registerUserEntityDTO.getPassword()));

        RoleEntity userRole = roleRepository.findByRole(RolesEnum.USER).orElseThrow(() -> new IllegalArgumentException("Role with that name does not exist!"));
        RoleEntity administatorRole = roleRepository.findByRole(RolesEnum.ADMINISTRATOR).orElseThrow(() -> new IllegalArgumentException("Role with that name does not exist!"));

        if (userRepository.count() == 0) {
            userEntity.addRole(userRole);
            userEntity.addRole(administatorRole);
        } else {
            userEntity.addRole(userRole);
        }

        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserEntityByUsername(String username) {
        return this.userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with this username was not found!"));
    }

    @Override
    public UserProfileDetailsDTO mapUserEntityToUserProfileDetailsDTO(UserEntity userEntity, UserProfileDetailsDTO userProfileDetailsDTO) {
        modelMapper.map(userEntity, userProfileDetailsDTO);

        return userProfileDetailsDTO;
    }
}
