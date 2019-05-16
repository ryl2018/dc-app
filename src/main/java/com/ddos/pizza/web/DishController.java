package com.ddos.pizza.web;

import com.ddos.pizza.common.Constant;
import com.ddos.pizza.common.rest.Result;
import com.ddos.pizza.domain.DishInfo;
import com.ddos.pizza.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("dish")
public class DishController {
    @Autowired
    private IDishService iDishService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addDish(@RequestBody DishInfo dishInfo) {
        DishInfo resDishInfo = iDishService.addDish(dishInfo);
        return Result.success(Constant.RES_DISH_ADD_MESSAGE,resDishInfo);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateDish(DishInfo dishInfo) {
        DishInfo resDishInfo = iDishService.updataDish(dishInfo);
        return Result.success(Constant.RES_DISH_UPDATE_MESSAGE,resDishInfo);
    }
    @RequestMapping(value = "/delete/{dishId}")
    public Result deleteDishById(@PathVariable UUID dishId) {
        iDishService.deleteDishById(dishId);
        return Result.success(Constant.RES_DISH_DELETE_MESSAGE);
    }
    @RequestMapping(value = "/getById/{dishId}")
    public DishInfo getById(@PathVariable UUID dishId) {
        return iDishService.getById(dishId);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<DishInfo> getAll() {
        return iDishService.getAll();
    }
    @RequestMapping(value = "/getByType/{dishTypeId}",method = RequestMethod.GET)
    public List<DishInfo> getByType(@PathVariable UUID dishTypeId) {
        return iDishService.getByType(dishTypeId);
    }
}
