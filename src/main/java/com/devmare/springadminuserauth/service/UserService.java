package com.devmare.springadminuserauth.service;

import com.devmare.springadminuserauth.dto.UserDto;
import com.devmare.springadminuserauth.model.User;

public interface UserService {
    User save(UserDto userDto);
}
