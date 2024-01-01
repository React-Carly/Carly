package com.carly.car.dto;

import com.carly.car.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarGetDto toDto(Car car);

    Car toEntity(CarCreateDto carCreateDto);
}
