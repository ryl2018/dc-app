package com.ddos.pizza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class IntercepterConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PizzaHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/register","/user/login","/user/isExistByUserPhone/*",
                        "/user/restPassword","/user/logout");
        super.addInterceptors(registry);
    }
}
