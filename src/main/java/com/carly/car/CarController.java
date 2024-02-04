package com.carly.car;

import com.carly.car.dto.CarCreateDto;
import com.carly.car.dto.CarGetDto;
import com.carly.car.dto.CarUpdateDto;
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
    public List<CarGetDto> getAllCars(@PageableDefault(size = 20, sort = "id") Pageable pageable) {
        return carService.getAllCars(pageable);
    }

    @GetMapping("/count")
    public Integer getCount() {
        return carService.getAllCars().toArray().length;
    }

    @GetMapping("/search")
    public List<CarGetDto> getAllCarsWithParams(Car car, @PageableDefault(size = 20, sort = "id") Pageable pageable) {
        return carService.getAllCars(car, pageable);
    }

    @GetMapping("/{id}")
    public CarGetDto getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @PatchMapping("/{id}")
    public CarGetDto updateCar(@PathVariable Long id, @RequestBody CarUpdateDto carUpdateDto) {
        return carService.updateCar(id, carUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
