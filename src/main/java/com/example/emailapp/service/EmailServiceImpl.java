package com.example.emailapp.service;

import com.example.emailapp.dto.request.EmailRequest;
import com.example.emailapp.models.Email;
import com.example.emailapp.repository.EmailRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private EmailRepository emailRepository;
    private ObjectMapper mapper;

    public EmailServiceImpl(EmailRepository emailRepository, ObjectMapper mapper) {
        this.emailRepository = emailRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EmailRequest> getEmails() {
        List<Email> emails = emailRepository.findAll();

        if (emails.isEmpty()) {
            return null;
        }

        return emails.stream()
                .map(email -> mapper.convertValue(email, EmailRequest.class))
                .toList();
    }

    @Override
    public EmailRequest createEmail(EmailRequest emailRequest) {
        Email createdEmail = mapper.convertValue(emailRequest, Email.class);
        emailRepository.save(createdEmail);
        return mapper.convertValue(createdEmail, EmailRequest.class);
    }
}
