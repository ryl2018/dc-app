package com.ddos.pizza.web;

import com.ddos.pizza.common.Constant;
import com.ddos.pizza.common.rest.Result;
import com.ddos.pizza.domain.User;
import com.ddos.pizza.common.exception.PizzaException;
import com.ddos.pizza.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {
    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        return iUserService.register(user);
    }

    @RequestMapping("/isExistByUserName/{userName}")
    public Result isExistByUserName(@PathVariable String userName) {
        boolean logic = iUserService.isExistByUserName(userName);
        if (!logic) {
            return Result.response(Constant.RES_USER_NAME_REPEAT, Constant.RES_USER_NAME_REPEAT_MESSAGE, userName);
        } else {
            return Result.success();
        }
    }

    @RequestMapping("/isExistByUserPhone/{phone}")
    public Result isExistByUserPhone(@PathVariable String phone) {
        boolean logic = iUserService.isExistByUserPhone(phone);
        if (logic) {
            return Result.success();
        } else {
            return Result.response(Constant.RES_USER_PHONE_REPEAT, Constant.RES_USER_PHONE_REPEAT_MESSAGE, phone);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        try {
            User u = iUserService.login(user);
            return Result.success(u);
        } catch (PizzaException e) {
            e.printStackTrace();
            return Result.response(Constant.RES_LOGIN_INAVLID, e.getMessage(), user);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody User user) {
        try {
            iUserService.update(user);
            return Result.success(user);
        } catch (PizzaException e) {
            e.printStackTrace();
            return Result.response(Constant.RES_LOGIN_FAIL, e.getMessage(), user);
        }
    }

    @RequestMapping(value = "/restPassword", method = RequestMethod.POST)
    public Result restPassword(@RequestBody User user) {
        User resUser = null;
        try {
            iUserService.restPassword(user);
        } catch (Exception e) {
            return Result.response(Constant.RES_LOGIN_FAIL,e.getMessage(),null);
        }
        return Result.success("密码修改成功",resUser);
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Result logout(HttpServletRequest request){
        String token = request.getHeader("pizza-Token");
        if (token!=null){
            iUserService.logout(token);
        }else {
            return Result.response(Constant.RES_LOGIN_FAIL,"token为空",null);
        }
        return Result.success("登出成功");
    }
}
