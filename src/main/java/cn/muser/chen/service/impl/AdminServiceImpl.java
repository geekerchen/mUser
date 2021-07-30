package cn.muser.chen.service.impl;

import cn.muser.chen.bo.MyUserDetails;
import cn.muser.chen.dao.UserDao;
import cn.muser.chen.entry.TUser;
import cn.muser.chen.service.AdminService;
import cn.muser.chen.service.UserCacheService;
import cn.muser.chen.service.UserService;
import cn.muser.chen.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/30 15:03
 **/
@Service
public class AdminServiceImpl implements AdminService {

/*
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserCacheService userCacheService;



    @Override
    public String login(String username, String password) {
        String token = null;
        UserDetails userDetails = loadUserByUsername(username);
        return null;
    }

    private UserDetails loadUserByUsername(String username) {
        //获取用户信息
        TUser user = getUserByMobile(username);
        if (user != null) {
            return new MyUserDetails(user);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    private TUser getUserByMobile(String username) {
        return new TUser();
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }
*/


}
