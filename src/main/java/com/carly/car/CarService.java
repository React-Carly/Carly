package com.carly.car;

import com.carly.car.dto.CarCreateDto;
import com.carly.car.dto.CarGetDto;
import com.carly.car.dto.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarGetDto createCar(CarCreateDto carCreateDto) {
        Car savedCar = carRepository.save(carMapper.toEntity(carCreateDto));
        return carMapper.toDto(savedCar);
    }

    public List<CarGetDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::toDto)
                .toList();
    }
}
