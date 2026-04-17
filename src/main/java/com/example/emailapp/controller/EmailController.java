package com.example.emailapp.controller;

import com.example.emailapp.dto.request.EmailRequest;
import com.example.emailapp.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getEmails")
    public ResponseEntity<List<EmailRequest>> getEmails() {
         List<EmailRequest> emailRequests = emailService.getEmails();
         return new ResponseEntity<>(emailRequests, HttpStatus.OK);
    }

    @PostMapping("/createEmail")
    public ResponseEntity<EmailRequest> createEmail(@RequestBody EmailRequest emailRequest) {
        EmailRequest createdEmail = emailService.createEmail(emailRequest);
        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }
}
