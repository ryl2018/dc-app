package com.ddos.pizza.service.impl;

import com.ddos.pizza.domain.DishType;
import com.ddos.pizza.mapper.DishTypeMapper;
import com.ddos.pizza.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;
@Service
public class DishTypeServiceImpl implements IDishTypeService {
    private final DishTypeMapper dishTypeMapper;
    @Autowired
    public DishTypeServiceImpl(DishTypeMapper dishTypeMapper) {
        this.dishTypeMapper = dishTypeMapper;
    }

    @Override
    public DishType addDishType(DishType dishType) {
        Assert.notNull(dishType,"dishType must not null");
        Assert.notNull(dishType.getName(),"dishType.name must not null");
        dishType.setId(UUID.randomUUID());
        dishTypeMapper.addDishType(dishType);
        return dishType;
    }

    @Override
    public DishType updataDishType(DishType dishType) {
        Assert.notNull(dishType,"dishType must not null");
        Assert.notNull(dishType.getName(),"dishType.name must not null");
        Assert.notNull(dishType.getId(),"dishType.id must not null");
        dishTypeMapper.updataDishType(dishType);
        return dishType;
    }

    @Override
    public void deleteDishTypeById(UUID dishId) {
        Assert.notNull(dishId,"dishId must not null");
        dishTypeMapper.deleteDishTypeById(dishId);
    }

    @Override
    public DishType getById(UUID dishId) {
        Assert.notNull(dishId,"dishId must not null");
        return dishTypeMapper.getById(dishId);
    }

    @Override
    public List<DishType> getAll() {
        return dishTypeMapper.getAll();
    }

    @Override
    public List<DishType> getRoot() {
        return dishTypeMapper.getRoot();
    }

    @Override
    public List<DishType> getChildren(UUID dishId) {
        Assert.notNull(dishId,"dishId must not null");
        return dishTypeMapper.getChildren(dishId);
    }
}
