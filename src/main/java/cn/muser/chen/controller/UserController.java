package cn.muser.chen.controller;

import cn.hutool.http.HttpRequest;
import cn.muser.chen.api.R;
import cn.muser.chen.dto.AdminLoginParam;
import cn.muser.chen.entry.TUser;
import cn.muser.chen.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public R login(@Validated @RequestBody  AdminLoginParam loginParam) {
        return userService.login(loginParam.getUsername(), loginParam.getPassword(),loginParam.getEquipment());
    }


    @GetMapping("/info")
    public R info(Integer token) {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        R<TUser> u = userService.getUserById(token);

        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("user",u.getData());
        return R.success(u);
    }

    @PostMapping("/logout")
    public R logout() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return R.success(map);
    }

    @GetMapping("/hi")
    public String hi() {
        return "userService.login(mobile, password)";
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/getList")
    public R<PageInfo<TUser>> list( int page,  int limit,@RequestParam Map<String, Object> paramsMap) {
        return userService.list(page,limit,paramsMap);
    }

    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public R<TUser> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public R<TUser> add(@RequestBody TUser user){
        return userService.add(user);
    }

    @ApiOperation("新增用户")
    @PostMapping("")
    public R<TUser> register(@RequestBody TUser user){
        return userService.register(user);
    }

    @ApiOperation("修改用户")
    @PutMapping
    public R<TUser> edit(@RequestBody TUser user){
        return userService.edit(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public R<TUser> add(@PathVariable int id){
        return userService.delete(id);
    }

    @ApiOperation("用户状态")
    @DeleteMapping("/{id}/{status}")
    public R<TUser> status(@PathVariable int id,@PathVariable String status){
        return userService.status(id,status);
    }

    @ApiOperation("用户状态")
    @DeleteMapping("/{id}/{status}")
    public R upload(HttpRequest request){
        return R.success(null);
    }
}
