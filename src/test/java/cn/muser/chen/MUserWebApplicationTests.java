package cn.muser.chen;

import cn.muser.chen.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class MUserWebApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
        System.out.println(1);

    }

    @Test
    void userList() {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile","188");
        map.put("status","VALID");
        System.out.println(userService.getUserById(1));
        System.out.println(userService.list(1,10,map));

    }

    @Test
    void userLogin() {

        System.out.println(userService.login("admin","123456"));

    }



}
