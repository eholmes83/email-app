package com.example.emailapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserCreatedException extends RuntimeException {
    public UserCreatedException(String message) {
        super(message);
    }
}
