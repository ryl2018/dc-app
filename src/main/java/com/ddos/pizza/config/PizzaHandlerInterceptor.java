package com.ddos.pizza.config;

import com.ddos.pizza.common.rest.Result;
import com.ddos.pizza.domain.User;
import com.ddos.pizza.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.UUID;

public class PizzaHandlerInterceptor implements HandlerInterceptor {
    @Resource
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("pizza-Token");
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (token == null || token.equals("")) {
            printJson(response, "");
            return false;
        }
        String userId = valueOperations.get(token);
        if (userId == null) {
            printJson(response, "");
            return false;
        }
        User user = userService.getUserById(UUID.fromString(userId));
        if (user == null) {
            printJson(response, "");
            return false;
        }
        valueOperations.set(token, userId);
        request.getSession().setAttribute("CONTEXT_USER_ID", userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
    }

    private static void printJson(HttpServletResponse response, String code) throws JsonProcessingException {
        Result responseResult = Result.response(50001, "token过期,请重新登陆", null);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(responseResult);
        printContent(response, content);
    }

    private static void printContent(HttpServletResponse response, String content) {
        try {
            response.setHeader("Content-Type", "application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.write(content);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
