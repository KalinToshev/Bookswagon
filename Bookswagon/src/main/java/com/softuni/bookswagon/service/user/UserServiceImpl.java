package com.softuni.bookswagon.service.user;

import com.softuni.bookswagon.model.dto.RegisterUserEntityDTO;
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
        // Create a new instance of the UserEntity class
        UserEntity userEntity = new UserEntity();

        // Map the fields of the registerUserEntityDTO object to the userEntity object using a ModelMapper
        modelMapper.map(registerUserEntityDTO, userEntity);

        // Set the user's password by encoding the password from the registerUserEntityDTO object using a password encoder
        userEntity.setPassword(passwordEncoder.encode(registerUserEntityDTO.getPassword()));

        // Retrieve the user role and administrator role from the role repository, or throw an exception if the role does not exist
        RoleEntity userRole = roleRepository.findByRole(RolesEnum.USER).orElseThrow(() -> new IllegalArgumentException("Role with that name does not exist!"));
        RoleEntity administatorRole = roleRepository.findByRole(RolesEnum.ADMINISTRATOR).orElseThrow(() -> new IllegalArgumentException("Role with that name does not exist!"));

        // If the number of users in the user repository is 0, add the user role and administrator role to the userEntity object
        if (userRepository.count() == 0) {
            userEntity.addRole(userRole);
            userEntity.addRole(administatorRole);
        } else {
            // Add the user role to the userEntity object
            userEntity.addRole(userRole);
        }

        // Save the userEntity object to the user repository
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserEntityByUsername(String username) {
        return this.userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with this username was not found!"));
    }
}
