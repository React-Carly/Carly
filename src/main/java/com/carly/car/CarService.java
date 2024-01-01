package com.carly.car;

import com.carly.car.dto.CarCreateDto;
import com.carly.car.dto.CarGetDto;
import com.carly.car.dto.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
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

    public List<CarGetDto> getAllCars(Car car, Pageable pageable) {
        var matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.EXACT);
        var example = Example.of(car, matcher);
        return carRepository.findAll(example, pageable).stream()
                .map(carMapper::toDto)
                .toList();
    }
}
