package com.devmare.springadminuserauth.service;

import com.devmare.springadminuserauth.dto.UserDto;
import com.devmare.springadminuserauth.model.User;
import com.devmare.springadminuserauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFullName());
        return userRepository.save(user);
    }
}
