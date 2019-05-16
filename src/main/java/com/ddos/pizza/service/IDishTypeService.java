package com.ddos.pizza.service;

import com.ddos.pizza.domain.DishType;
import java.util.List;
import java.util.UUID;

public interface IDishTypeService {
    DishType addDishType(DishType dishType);
    DishType updataDishType(DishType dishType);
    void deleteDishTypeById(UUID dishId);
    DishType getById(UUID dishId);
    List<DishType> getAll();
    List<DishType> getRoot();
    List<DishType> getChildren(UUID dishId);
}
