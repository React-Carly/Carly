package com.carly.user.dto;

import com.carly.user.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserGetDto {
    private Long id;

    private String username;
    private String name;
    private Role role;
}
