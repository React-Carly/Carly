package com.carly.car.dto;

import com.carly.car.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {
    CarGetDto toDto(Car car);

    Car toEntity(CarCreateDto carCreateDto);

    void updateCar(CarUpdateDto sourceCarDto, @MappingTarget Car targetCar);
}
