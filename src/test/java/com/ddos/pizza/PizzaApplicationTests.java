package com.ddos.pizza;

import com.ddos.pizza.domain.User;
import com.ddos.pizza.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaApplicationTests<readObject> {

    private static long oldOrder = 0;
    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Autowired
    private UserMapper usersMapper;
    @Test
    public void contextLoads() throws IOException {
        User u = new User();
        UUID id = UUID.randomUUID();
        u.setId(id);
//        System.out.print(id);
        u.setName("ddsados");
        u.setPassword("1ada23");
        u.setPhone("9922399");
        u.setTrueName("Sasy");
        usersMapper.register(u);
//        System.out.print(u);
//        String test = newOrder();
//        System.out.println(test);
//        long o = string2Order(test);
//        System.out.println(o);
//        StringBuffer rt = new StringBuffer(10);
//        while (o > 0) {
//            rt.insert(0, chars.charAt((int) (o % 36)));
//            o = o / 36;
//        }
//        System.out.println(rt.toString());
//          writeObject(u);
//          System.out.println(u);
//        User user = readObject();
//        System.out.println(user);
    }
    public static String newOrder() {
//        long order = System.currentTimeMillis();
//        if (order <= oldOrder)
//        	order = oldOrder + 1;
//        while (order <= oldOrder) {
//            order++;
//        }
//        oldOrder = order;
        long	order = newOrderID();

        StringBuffer rt = new StringBuffer(10);
        while (order > 0) {
            rt.insert(0, chars.charAt((int) (order % 36)));
            order = order / 36;
        }
        return rt.toString();
    }

    /**
     * 生成一个新的顺序号编码值
     * @return 返回顺序号值
     */
    public synchronized static long newOrderID() {
        long order = System.currentTimeMillis();
        if (order <= oldOrder)
            order = oldOrder + 1;
        oldOrder = order;
        System.out.println(order);
        return order;
    }
    public static long string2Order(String test){
        long res = 0;
        for (int i = 0;i<test.length();i++){
            res =res* chars.indexOf(test.charAt(i))*36;
        }
        return res;
    }
    public static void writeObject(User user) throws IOException {
        File file = new File("D:/1.txt");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        o.writeObject(user);
        o.close();
    }
    public static User readObject(){
        File file = new File("D:/1.txt");
        User object = null;
        try(ObjectInputStream i = new ObjectInputStream(new FileInputStream(file))){
            object = (User)i.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
}
