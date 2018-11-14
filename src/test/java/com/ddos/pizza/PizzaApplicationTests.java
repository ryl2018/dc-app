package com.ddos.pizza;

import com.ddos.pizza.domain.User;
import com.ddos.pizza.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaApplicationTests {
    @Autowired
    private UserMapper usersMapper;
    @Test
    public void contextLoads() {
        User u = new User();
        UUID id = UUID.randomUUID();
        u.setId(id);
        System.out.print(id);
        u.setName("ddos");
        u.setPassword("123");
        u.setPhone("99999999999");
        u.setTrueName("Liy");
        usersMapper.register(u);
        System.out.print(u);
    }

}
