package com.softuni.bookswagon.service.user;

import com.softuni.bookswagon.model.dto.RegisterUserEntityDTO;
import com.softuni.bookswagon.model.dto.UserProfileDetailsDTO;
import com.softuni.bookswagon.model.entity.UserEntity;

public interface UserService {
    void registerUser(RegisterUserEntityDTO registerUserEntityDTO);

    UserEntity getUserEntityByUsername(String username);

    UserProfileDetailsDTO mapUserEntityToUserProfileDetailsDTO(UserEntity userEntity, UserProfileDetailsDTO userProfileDetailsDTO);
}
