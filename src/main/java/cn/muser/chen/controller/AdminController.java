package cn.muser.chen.controller;

import cn.muser.chen.api.R;
import cn.muser.chen.dto.AdminLoginParam;
import cn.muser.chen.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/30 14:54
 **/

@Api(tags = "AdminController", value = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class AdminController {

  /*  @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "登录以后返回token")
    @GetMapping("/login")
    @ResponseBody
    public R login(@Validated @RequestBody AdminLoginParam loginParam) {
        String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return R.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return R.success(tokenMap);
    }*/

}
