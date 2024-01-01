package com.carly.user;

import com.carly.user.dto.UserGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserGetDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserGetDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

}
