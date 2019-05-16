package com.ddos.pizza.web;

import com.ddos.pizza.common.Constant;
import com.ddos.pizza.common.rest.Result;
import com.ddos.pizza.domain.DishType;
import com.ddos.pizza.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("dishType")
public class DishTypeController {
    @Autowired
    private IDishTypeService iDishTypeService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addDishType(@RequestBody DishType dishType) {
        DishType resDishType = iDishTypeService.addDishType(dishType);
        return Result.success(Constant.RES_TYPE_ADD_MESSAGE,resDishType);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateDishType(DishType dishType) {
        DishType resDishType = iDishTypeService.updataDishType(dishType);
        return Result.success(Constant.RES_TYPE_UPDATE_MESSAGE,resDishType);
    }
    @RequestMapping(value = "/delete/{dishTypeId}")
    public Result deleteDishTypeById(@PathVariable UUID dishTypeId) {
        iDishTypeService.deleteDishTypeById(dishTypeId);
        return Result.success(Constant.RES_TYPE_DELETE_MESSAGE);
    }
    @RequestMapping(value = "/getById/{dishTypeId}")
    public DishType getById(@PathVariable UUID dishTypeId) {
        return iDishTypeService.getById(dishTypeId);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<DishType> getAll() {
        return iDishTypeService.getAll();
    }
    @RequestMapping(value = "/getRoot",method = RequestMethod.GET)
    public List<DishType> getRoot() {
        return iDishTypeService.getRoot();
    }
    @RequestMapping(value = "/getChildren/{dishTypeId}",method = RequestMethod.GET)
    public List<DishType> getChildren(@PathVariable UUID dishTypeId) {
        return iDishTypeService.getChildren(dishTypeId);
    }
}
