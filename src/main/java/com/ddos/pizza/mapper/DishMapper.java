package com.ddos.pizza.mapper;

import com.ddos.pizza.domain.DishInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper
@Service
public interface DishMapper {
    void addDish(DishInfo dishInfo);
    void updataDish(DishInfo dishInfo);
    void deleteDishById(UUID dishId);
    DishInfo getById(UUID dishId);
    List<DishInfo> getAll();
    List<DishInfo> getByType(UUID typeId);
}
