package com.example.emailapp.dto.response;

import com.example.emailapp.models.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {
    private List<Email> emails;
}
