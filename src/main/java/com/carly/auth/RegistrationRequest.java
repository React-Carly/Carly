package com.carly.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "City cannot be blank")
    @NotNull(message = "City cannot be null")
    private String city;
    @NotBlank(message = "Street cannot be blank")
    @NotNull(message = "Street cannot be null")
    private String street;
    @NotBlank(message = "Zip code cannot be blank")
    @NotNull(message = "Zip code cannot be null")
    private String zipCode;
}
