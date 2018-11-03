package com.ddos.pizza;

import com.ddos.pizza.domain.User;
import com.ddos.pizza.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaApplicationTests {
    @Autowired
    private UserMapper usersMapper;
    @Test
    public void contextLoads() {
        User u = new User();
        u.setUserName("xiaohei");
        u.setUserPass("aaa");
        u = usersMapper.login(u);
        System.out.print(u);
    }

}
