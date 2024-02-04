package com.carly.user.dto;

import com.carly.user.Role;


public record UserGetDto(
        Long id,
        String username,
        String name,
        Role role,
        String city,
        String street,
        String zipCode,
        String createdAt
) {
}
