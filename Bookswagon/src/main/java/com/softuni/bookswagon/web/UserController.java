package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.UserProfileDetailsDTO;
import com.softuni.bookswagon.model.entity.UserEntity;
import com.softuni.bookswagon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/profile")
    public String getUserProfileDetails(Principal principal, Model model) {
        var userEntity = this.userService.getUserEntityByUsername(principal.getName());

        UserProfileDetailsDTO userProfileDetailsDTO = new UserProfileDetailsDTO();

        this.userService.mapUserEntityToUserProfileDetailsDTO(userEntity, userProfileDetailsDTO);

        model.addAttribute("userProfileDetailsDTO", userProfileDetailsDTO);

        return "profile";
    }
}
