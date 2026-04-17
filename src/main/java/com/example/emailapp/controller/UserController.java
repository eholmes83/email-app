package com.example.emailapp.controller;

import com.example.emailapp.dto.request.UserRequest;
import com.example.emailapp.dto.response.UserResponse;
import com.example.emailapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userRequest) {
        UserRequest createdUser = userService.createUser(userRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRequest> updateUser(@RequestBody UserRequest userRequest,
                                                @PathVariable Long id) {
        UserRequest updatedUser = userService.updateUser(userRequest, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserRequest> deleteUser(@PathVariable Long id) {
        UserRequest deletedUser = userService.deleteUser(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
