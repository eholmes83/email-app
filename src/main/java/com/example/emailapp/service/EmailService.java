package com.example.emailapp.service;

import com.example.emailapp.dto.request.EmailRequest;

import java.util.List;

public interface EmailService {
    List<EmailRequest> getEmails();
    EmailRequest createEmail(EmailRequest emailRequest);

    EmailRequest deleteEmail(Long id);

    EmailRequest updateEmail(EmailRequest emailRequest, Long id);
}
