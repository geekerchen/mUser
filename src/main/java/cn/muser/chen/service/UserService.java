package cn.muser.chen.service;

import cn.muser.chen.api.R;
import cn.muser.chen.entry.TUser;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService {

    R<PageInfo<TUser>> list(int pageNum, int pageSize, Map<String, Object> paramsMap);

    R<TUser> getUserById(int id);

    R<TUser> add(TUser user);

    R<TUser> delete(int id);

    R<TUser> edit(TUser user);

    R login(String mobile, String password);

    /**
     * 获取用户信息
     */
    TUser getUserByMobile(String username);

    R<TUser> status(int id, String status);

    R<TUser> register(TUser user);
}
