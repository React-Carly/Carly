package com.carly.user;

import com.carly.user.dto.UserGetDto;
import com.carly.user.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserGetDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::toUDto).collect(Collectors.toList());
    }

    public UserGetDto getById(Long id) {
        return userMapper.toUDto(userRepository.findById(id).orElseThrow());
    }
}
