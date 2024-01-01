package com.carly.user.dto;

import com.carly.user.Role;

public record UserUpdateDto(
        String username,
        String name,
        Role role
) {
}
