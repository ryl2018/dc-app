package com.ddos.pizza.mapper;

import com.ddos.pizza.domain.DishType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper
@Service
public interface DishTypeMapper {
    void addDishType(DishType dishType);
    void updataDishType(DishType dishType);
    void deleteDishTypeById(UUID dishId);
    DishType getById(UUID dishId);
    List<DishType> getAll();
    List<DishType> getRoot();
    List<DishType> getChildren(UUID dishId);
}
