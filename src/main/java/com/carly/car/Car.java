package com.carly.car;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    @NotNull
    private String brand;
    @NotBlank
    @NotNull
    private String model;
    @NotNull
    private FuelType fuelType;
    @NotNull
    private Integer mileage;
    @NotNull
    private Short seats;
    @NotBlank
    @NotNull
    private String color;
    @NotNull
    private Integer year;
    @NotNull
    private Integer pricePerHour;
    private String description;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    private Double latitude;
    private Double longitude;
//    private List<String> images;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Car car = (Car) o;
        return getId() != null && Objects.equals(getId(), car.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
