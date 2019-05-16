package com.ddos.pizza.service;

import com.ddos.pizza.domain.DishInfo;

import java.util.List;
import java.util.UUID;

public interface IDishService {
    DishInfo addDish(DishInfo dishInfo);
    DishInfo updataDish(DishInfo dishInfo);
    void deleteDishById(UUID dishId);
    DishInfo getById(UUID dishId);
    List<DishInfo> getAll();
    List<DishInfo> getByType(UUID typeId);
}
