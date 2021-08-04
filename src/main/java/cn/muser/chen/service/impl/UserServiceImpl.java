package cn.muser.chen.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import cn.muser.chen.api.R;
import cn.muser.chen.dao.UserDao;
import cn.muser.chen.entry.TUser;
import cn.muser.chen.service.UserCacheService;
import cn.muser.chen.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/29 18:04
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCacheService userCacheService;

/*    @Autowired*/

    @Override
    public R<PageInfo<TUser>> list(int pageNum,int pageSize, Map<String, Object> paramsMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<TUser> list = userDao.getUserList(paramsMap);
        PageInfo pageInfo = new PageInfo(list);
        return R.success(pageInfo);
    }

    @Override
    public R<TUser> getUserById(int id) {
        TUser u = userDao.selectById(id);
        if (u != null) {
            return R.success(u);
        }else {
            return R.failed("该用户不存在");
        }

    }

    @Override
    public R<TUser> status(int id, String status) {
        TUser u = userDao.selectById(id);
        u.setStatus(status);
        int res = userDao.updateById(u);
        if(res>0){
            return R.success(null,"状态更新成功");
        }else {
            return R.success(null,"状态更新失败");
        }
    }

    @Override
    public R register(TUser user) {
        TUser u = getUserByMobile(user.getMobile());
        if(u!=null){
            return R.failed("该手机已注册");
        }else{
            String salt = BCrypt.gensalt(10);
            String hashedPassword = BCrypt.hashpw(user.getPwd(), salt);
            user.setPwdSalt(salt);
            user.setPwd(hashedPassword);
            int i = userDao.insert(user);
            TUser uer = getUserByMobile(user.getMobile());
            user.setCreateBy(user.getId());
            userDao.updateById(user);
            return R.success(null,"注册成功");
        }
    }


    @Override
    public R add(TUser user) {
        TUser u = getUserByMobile(user.getMobile());
        if(u!=null){
            return R.failed("该手机已注册");
        }else {
            String salt = BCrypt.gensalt(10);
            String hashedPassword = BCrypt.hashpw(user.getPwd(), salt);
            user.setPwdSalt(salt);
            user.setPwd(hashedPassword);
            int i = userDao.insert(user);
            if(i > 0){
                return R.success(user,"添加成功");
            }else {
                return R.failed("添加失败");
            }
        }
    }

    @Override
    public R<TUser> delete(int id) {
        TUser user = userDao.selectById(id);
        user.setStatus("DEL");
        int i = userDao.updateById(user);
        if(i > 0){
            return R.success(null,"删除成功");
        }else {
            return R.failed("删除失败");
        }
    }

    @Override
    public R<TUser> edit(TUser user) {
        String salt = BCrypt.gensalt(10);
        String hashedPassword = BCrypt.hashpw(user.getPwd(), salt);
        user.setPwdSalt(salt);
        user.setPwd(hashedPassword);
        user.setUpdateTime(new Date());
        int i = userDao.updateById(user);
        if(i > 0){
            return R.success(null,"更新成功");
        }else {
            return R.failed("更新失败");
        }
    }

    @Override
    public R login(String mobile, String password,String equipment) {
        TUser u = getUserByMobile(mobile);
        //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //用户存在
        if (u != null ){
            //密码正确通过
            boolean validPwd = BCrypt.checkpw(password,u.getPwd());
            if(validPwd && "VALID".equals(u.getStatus())){
                Map<String,Object> m = new HashMap<>();
                //把ID 传作token
                m.put("token",u.getId());
                u.setLastFailedTimes(0);
                u.setLastLoginTime(new Date());
                u.setLastLoginEqpt(equipment);
                try {
                    u.setLastLoginIp(String.valueOf(Inet4Address.getLocalHost()));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                userDao.updateById(u);
                return R.success(m, "登录成功");
            }else if(validPwd &&  "FROZEN".equals(u.getStatus())){
                //密码正确 用户被锁定
                return R.success(null, "用户已被锁定");
            }else if("DEL".equals(u.getStatus())){
                //用户被注销
                return R.failed("用户不存在");
            }else{
                //密码不正确，计算失败次数 >5 的时候锁定
                int failedTime = u.getLastFailedTimes();
                if(failedTime >=4){
                    //冻结用户
                    u.setStatus("FROZEN");
                    u.setLastFailedTimes(5);
                    userDao.updateById(u);
                    return R.failed("用户已被锁定，请联系客服申诉10086");
                }else{
                    u.setLastFailedTimes(failedTime +1);
                    userDao.updateById(u);
                    return R.failed("密码错误,已连续登录失败"+ Integer.valueOf(failedTime+1) +"次，还有"+ Integer.valueOf(4-failedTime) +"次机会");
                }
            }

        }else {
            //不存在
            return R.failed("用户不存在");
        }
    }

    /**
     *  获取用户
     * @param username
     * @return
     */
    @Override
    public TUser getUserByMobile(String username) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        String[] status = {"VALID","FROZEN"};
        queryWrapper.eq("mobile",username)
                .in("status",status);
        List<TUser> list = userDao.selectList(queryWrapper);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }



}
