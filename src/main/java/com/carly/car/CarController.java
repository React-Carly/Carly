package com.carly.car;

import com.carly.car.dto.CarCreateDto;
import com.carly.car.dto.CarGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/search")
    public List<CarGetDto> getAllCarsWithParams(Car car, @PageableDefault(size = 20, sort = "name") Pageable pageable) {
        return carService.getAllCars(car, pageable);
    }
}
