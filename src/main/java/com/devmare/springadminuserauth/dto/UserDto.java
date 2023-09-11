package com.devmare.springadminuserauth.dto;

import lombok.*;

@Data
public class UserDto {
    private String email;
    private String password;
    private String role;
    private String fullName;
}
