package com.example.emailapp.service;

import com.example.emailapp.dto.request.UserRequest;
import com.example.emailapp.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserRequest createUser(UserRequest userRequest);
    List<UserResponse> getUsers();

    UserRequest updateUser(UserRequest userRequest, Long id);

    UserRequest deleteUser(Long id);
}
