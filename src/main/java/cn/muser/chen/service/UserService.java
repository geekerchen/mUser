package cn.muser.chen.service;

import cn.muser.chen.entry.User;

import java.util.List;

public interface UserService {
    List<User> list(String keyword, Integer pageSize, Integer pageNum);
}
