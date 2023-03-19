package com.example.AS.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupValidationExMessage {
    private LocalDateTime localDateTime;
    private int status;
    private String error;
    private String path;
}
