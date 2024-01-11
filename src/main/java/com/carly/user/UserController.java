package com.carly.user;

import com.carly.reservation.dto.ReservationGetDto;
import com.carly.user.dto.UserGetDto;
import com.carly.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/reservations")
    public List<ReservationGetDto> getReservationsById(@PathVariable Long id) {
        return userService.getReservationsByUserId(id);
    }

    @PatchMapping("/{id}")
    public UserGetDto updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(id, userUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
