package com.carly.user;

import com.carly.reservation.ReservationRepository;
import com.carly.reservation.dto.ReservationGetDto;
import com.carly.reservation.dto.ReservationMapper;
import com.carly.user.dto.UserGetDto;
import com.carly.user.dto.UserMapper;
import com.carly.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final UserMapper userMapper;
    private final ReservationMapper reservationMapper;

    public List<UserGetDto> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(userMapper::toUDto).collect(Collectors.toList());
    }

    public List<UserGetDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::toUDto).collect(Collectors.toList());
    }

    public UserGetDto getById(Long id) {
        return userMapper.toUDto(userRepository.findById(id).orElseThrow());
    }

    public List<ReservationGetDto> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId).stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    public UserGetDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        var user = userRepository.getReferenceById(id);
        userMapper.updateUser(userUpdateDto, user);
        return userMapper.toUDto(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserGetDto> getByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(userMapper::toUDto).collect(Collectors.toList());
    }
}
