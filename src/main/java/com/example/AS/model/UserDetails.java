package com.example.AS.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String lastname;
    @NotBlank
    @NotNull
    @Pattern(regexp = "[a-zA-Z]{1,}\\w*@acme.com")
    private String email;
    @NotBlank
    @NotNull
    private String password;
}
