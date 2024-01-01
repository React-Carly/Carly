package com.carly.car;

import com.carly.car.dto.CarCreateDto;
import com.carly.car.dto.CarGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public CarGetDto createCar(@RequestBody CarCreateDto carCreateDto) {
        return carService.createCar(carCreateDto);
    }

    @GetMapping
    public List<CarGetDto> getAllCars() {
        return carService.getAllCars();
    }
}
