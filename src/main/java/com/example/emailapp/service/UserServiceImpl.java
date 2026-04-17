package com.example.emailapp.service;

import com.example.emailapp.dto.request.UserRequest;
import com.example.emailapp.dto.response.UserResponse;
import com.example.emailapp.exception.UserCreatedException;
import com.example.emailapp.models.User;
import com.example.emailapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ObjectMapper mapper;

        public UserServiceImpl(UserRepository userRepository, ObjectMapper mapper) {
            this.userRepository = userRepository;
            this.mapper = mapper;
        }

    public UserRequest createUser(UserRequest userRequest) {
         User userToCreate = mapper.convertValue(userRequest, User.class);
         User existingUser = userRepository.findByEmailAddress(userToCreate.getEmailAddress());
            if (existingUser != null) {
                throw new UserCreatedException("User with " + existingUser.getEmailAddress() + " email address already exists");
            }

            User savedUser = userRepository.save(userToCreate);
            return mapper.convertValue(savedUser, UserRequest.class);
    }

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new UserCreatedException("No users found!");
        }

       return users.stream()
               .map(user -> mapper.convertValue(user, UserResponse.class))
               .toList();
    }

    @Override
    public UserRequest updateUser(UserRequest userRequest, Long id) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new UserCreatedException("User with id " + id + " not found!"));

        userToUpdate.setEmailAddress(userRequest.getEmailAddress());
        userToUpdate.setPassword(userRequest.getPassword());

        User updatedUser = userRepository.save(userToUpdate);
        return mapper.convertValue(updatedUser, UserRequest.class);
    }

    @Override
    public UserRequest deleteUser(Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new UserCreatedException("User with id " + id + " not found!"));

        userRepository.delete(userToDelete);
        return mapper.convertValue(userToDelete, UserRequest.class);
    }
}
