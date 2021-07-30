package cn.muser.chen.service.impl;

import cn.muser.chen.api.CommonPage;
import cn.muser.chen.api.CommonResult;
import cn.muser.chen.dao.UserDao;
import cn.muser.chen.entry.TUser;
import cn.muser.chen.service.UserCacheService;
import cn.muser.chen.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
    public CommonResult<CommonPage<TUser>> list(Map<String, Object> paramsMap) {
        List<TUser> list = userDao.selectByMap(paramsMap);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @Override
    public CommonResult<TUser> getUserById(String id) {
        TUser u = userDao.selectById(id);
        if (u != null) {
            return CommonResult.success(u);
        }else {
            return CommonResult.failed("该用户不存在");
        }

    }



    @Override
    public CommonResult add(TUser user) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",user.getMobile());
        TUser u = userDao.selectOne(queryWrapper);
        if(u == null){
            int i = userDao.insert(user);
            if(i > 0){
                return CommonResult.success(user,"添加成功");
            }else {
                return CommonResult.failed("添加失败");
            }
        }else {
            return CommonResult.failed("该手机已注册");
        }
    }

    @Override
    public CommonResult<TUser> delete(String id) {
        int i = userDao.deleteById(id);
        if(i > 0){
            return CommonResult.success(null,"删除成功");
        }else {
            return CommonResult.failed("删除失败");
        }
    }

    @Override
    public CommonResult<TUser> edit(TUser user) {
        int i = userDao.updateById(user);
        if(i > 0){
            return CommonResult.success(null,"更新成功");
        }else {
            return CommonResult.failed("更新失败");
        }
    }

    @Override
    public CommonResult login(String mobile, String password) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",mobile);
        TUser u = userDao.selectOne(queryWrapper);
        //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (u.getPwd().equals(password)){
            return CommonResult.success(1, "登录成功");
        }else {
            return CommonResult.failed("用户名或密码错误");
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
        queryWrapper.eq("mobile",username);
        TUser u = userDao.selectOne(queryWrapper);
        if(u != null){
            return u;
        }
        return null;
    }

}
