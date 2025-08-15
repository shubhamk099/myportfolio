package com.codeplay.myportfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be alteast 3 characters long")
    private String fullName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Message must be blank")
    @Size(min = 10, message = "Messgae must be atleast 10 characters long")
    private String message;
}
