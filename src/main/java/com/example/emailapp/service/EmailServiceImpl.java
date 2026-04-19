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
           throw new RuntimeException("No emails found!");
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

    @Override
    public EmailRequest deleteEmail(Long id) {
        Email emailToDelete = emailRepository.findById(id).orElse(null);

        if (emailToDelete == null) {
            throw new RuntimeException("Email with id " + id + " not found!");
        }

        emailRepository.delete(emailToDelete);
        return mapper.convertValue(emailToDelete, EmailRequest.class);
    }

    @Override
    public EmailRequest updateEmail(EmailRequest emailRequest, Long id) {
        Email emailToUpdate = emailRepository.findById(id).orElse(null);

        if (emailToUpdate == null) {
            throw new RuntimeException("Email with id " + id + " not found!");
        }

        emailToUpdate.setSubject(emailRequest.getSubject());
        emailToUpdate.setBody(emailRequest.getBody());
        emailToUpdate.setSender(emailRequest.getSender());
        emailToUpdate.setRecipient(emailRequest.getRecipient());
        emailToUpdate.setIsRead(emailRequest.getIsRead());

        Email updateEmail = emailRepository.save(emailToUpdate);
        return mapper.convertValue(updateEmail, EmailRequest.class);

    }
}
