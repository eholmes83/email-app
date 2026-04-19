package com.example.emailapp.controller;

import com.example.emailapp.dto.request.EmailRequest;
import com.example.emailapp.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping()
    public ResponseEntity<List<EmailRequest>> getEmails() {
         List<EmailRequest> emailRequests = emailService.getEmails();
         return new ResponseEntity<>(emailRequests, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmailRequest> createEmail(@RequestBody EmailRequest emailRequest) {
        EmailRequest createdEmail = emailService.createEmail(emailRequest);
        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmailRequest> deleteEmail(@PathVariable Long id) {
        EmailRequest deletedEmail = emailService.deleteEmail(id);
        return new ResponseEntity<>(deletedEmail, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailRequest> updateEmail(@RequestBody EmailRequest emailRequest,
                                                    @PathVariable Long id) {
        EmailRequest updatedEmail = emailService.updateEmail(emailRequest, id);
        return new ResponseEntity<>(updatedEmail, HttpStatus.OK);
    }
}
