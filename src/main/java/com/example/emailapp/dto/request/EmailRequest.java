package com.example.emailapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailRequest {
    private Long id;
    private String senderEmail;
    private String recipientEmail;
    private String subject;
    private String body;
    //private Boolean isRead;
}
