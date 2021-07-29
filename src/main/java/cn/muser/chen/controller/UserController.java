package cn.muser.chen.controller;

import cn.muser.chen.api.CommonPage;
import cn.muser.chen.api.CommonResult;
import cn.muser.chen.entry.User;
import cn.muser.chen.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/29 18:03
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("获取用户列表")
    @GetMapping
    public CommonResult<CommonPage<User>> list(String keyword, Integer pageSize, Integer pageNum) {
        List<User> list = userService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

}
