package com.ddos.pizza.service.impl;

import com.ddos.pizza.domain.DishInfo;
import com.ddos.pizza.mapper.DishMapper;
import com.ddos.pizza.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;
@Service
public class DishServiceImpl implements IDishService {
    @Autowired
    private DishMapper dishMapper;
    @Override
    public DishInfo addDish(DishInfo dishInfo) {
        Assert.notNull(dishInfo,"dishInfo must not null");
        Assert.notNull(dishInfo.getName(),"dishInfo.name must not null");
        Assert.notNull(dishInfo.getType(),"dishInfo.type must not null");
        Assert.notNull(dishInfo.getImgAddress(),"dishInfo.img must not null");
        dishInfo.setId(UUID.randomUUID());
        dishMapper.addDish(dishInfo);
        return dishInfo;
    }

    @Override
    public DishInfo updataDish(DishInfo dishInfo) {
        Assert.notNull(dishInfo,"dishInfo must not null");
        Assert.notNull(dishInfo.getName(),"dishInfo.name must not null");
        Assert.notNull(dishInfo.getType(),"dishInfo.type must not null");
        Assert.notNull(dishInfo.getImgAddress(),"dishInfo.img must not null");
        Assert.notNull(dishInfo.getId(),"dishInfo.id must not null");
        dishMapper.updataDish(dishInfo);
        return dishInfo;
    }

    @Override
    public void deleteDishById(UUID dishId) {
        Assert.notNull(dishId,"dishId must not null");
        dishMapper.deleteDishById(dishId);
    }

    @Override
    public DishInfo getById(UUID dishId) {
        Assert.notNull(dishId,"dishId must not null");
        return dishMapper.getById(dishId);
    }

    @Override
    public List<DishInfo> getAll() {
        return dishMapper.getAll();
    }

    @Override
    public List<DishInfo> getByType(UUID typeId) {
        Assert.notNull(typeId,"typeId must not null");
        return dishMapper.getByType(typeId);
    }
}
