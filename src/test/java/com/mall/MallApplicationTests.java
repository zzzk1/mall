package com.mall;

import com.mall.mbg.model.TUser;
import com.mall.service.UserService;
import com.mall.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MallApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void getUser() {
        System.out.println(userService.getUser(1));
    }

    @Test
    void deleteUser() {
        System.out.println(userService.deleteUser(2));
    }

    @Test
    void getAllUser() {
        List<TUser> tUsers = userService.getAll();
        for (TUser tUser : tUsers) {
            System.out.println(tUser);
        }
    }

    @Test
    void addUser() {
        userService.addUser(new TUser("root", "root"));
    }

    @Test
    void getPageUser() {
        List<TUser> userList = userService.getPageUser(1, 2);
        for (TUser user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void updateUser() {
        TUser tUser = new TUser("root", "root");
        userService.updateUser(3,tUser);
    }
}
