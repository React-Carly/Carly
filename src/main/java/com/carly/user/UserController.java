package com.carly.user;

import com.carly.reservation.dto.ReservationGetDto;
import com.carly.user.dto.UserGetDto;
import com.carly.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserGetDto> getAll(@RequestParam(required = false) String username, @PageableDefault(size = 20, sort = "id") Pageable pageable) {
        if (username != null) return userService.getByUsername(username);
        return userService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public UserGetDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/count")
    public Integer getCount() {
        return userService.getAll().toArray().length;
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
