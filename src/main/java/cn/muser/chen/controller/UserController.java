package cn.muser.chen.controller;

import cn.muser.chen.api.CommonPage;
import cn.muser.chen.api.CommonResult;
import cn.muser.chen.dto.AdminLoginParam;
import cn.muser.chen.entry.TUser;
import cn.muser.chen.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/29 18:03
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "UserController",value = "用户管理")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody  AdminLoginParam loginParam) {
        return userService.login(loginParam.getUsername(), loginParam.getPassword());
    }

    @GetMapping("/hi")
    public String hi() {
        return "userService.login(mobile, password)";
    }

    @ApiOperation("获取用户列表")
    @GetMapping
    public CommonResult<CommonPage<TUser>> list(String keyword, Integer pageSize, Integer pageNum) {
        Map<String,Object> map = new HashMap<>();
        return userService.list(map);
    }

    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public CommonResult<TUser> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @ApiOperation("新增用户")
    @PostMapping
    public CommonResult<TUser> add(@RequestBody TUser user){
        return userService.add(user);
    }

    @ApiOperation("修改用户")
    @PutMapping
    public CommonResult<TUser> edit(@RequestBody TUser user){
        return userService.edit(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public CommonResult<TUser> add(@PathVariable String id){
        return userService.delete(id);
    }

}
