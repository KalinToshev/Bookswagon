package com.softuni.bookswagon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileDetailsDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String email;
}
