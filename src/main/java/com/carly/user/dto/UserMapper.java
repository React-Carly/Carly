package com.carly.user.dto;


import com.carly.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserGetDto toUDto(User user);
}
