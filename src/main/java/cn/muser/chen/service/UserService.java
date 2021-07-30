package cn.muser.chen.service;

import cn.muser.chen.api.CommonPage;
import cn.muser.chen.api.CommonResult;
import cn.muser.chen.entry.TUser;

import java.util.Map;

public interface UserService {

    CommonResult<CommonPage<TUser>> list(Map<String, Object> paramsMap);

    CommonResult<TUser> getUserById(String id);

    CommonResult<TUser> add(TUser user);

    CommonResult<TUser> delete(String id);

    CommonResult<TUser> edit(TUser user);

    CommonResult login(String mobile, String password);

    /**
     * 获取用户信息
     */
    TUser getUserByMobile(String username);
}
