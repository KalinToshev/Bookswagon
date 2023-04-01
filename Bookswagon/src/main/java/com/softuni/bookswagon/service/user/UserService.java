package com.softuni.bookswagon.service.user;

import com.softuni.bookswagon.model.dto.RegisterUserEntityDTO;
import com.softuni.bookswagon.model.dto.UserInfoForAdminDTO;
import com.softuni.bookswagon.model.dto.UserProfileDetailsDTO;
import com.softuni.bookswagon.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    void registerUser(RegisterUserEntityDTO registerUserEntityDTO);

    UserEntity getUserEntityByUsername(String username);

    UserProfileDetailsDTO mapUserEntityToUserProfileDetailsDTO(UserEntity userEntity, UserProfileDetailsDTO userProfileDetailsDTO);

    List<UserInfoForAdminDTO> findAllUsersAndMapForAdminPanel();

    void deleteById(Long id);
}
