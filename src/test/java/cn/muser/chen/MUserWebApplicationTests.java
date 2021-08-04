package cn.muser.chen;

import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.BCrypt;
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
        BCrypt bCrypt = new BCrypt();
        String db = "$2a$10$9C3bCKV7S.LaBFU1aBisDe1Q.zCChCqSKhqGJUEU7Pq/NwtFYzjdu";
        String password ="123456";
        String salt = bCrypt.gensalt(10);
        String hashed = bCrypt.hashpw(password,"123");
        System.out.println(hashed);
        System.out.println(salt);
        if(bCrypt.checkpw(password,db)){
            System.out.println(1);
        }else {
            System.out.println(2);
        }

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

        System.out.println(userService.login("admin","123456","iphone12"));

    }



}
