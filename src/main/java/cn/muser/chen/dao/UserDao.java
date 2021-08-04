package cn.muser.chen.dao;

import cn.muser.chen.entry.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/30 8:47
 **/
@Mapper
@CacheConfig(cacheNames = "user")
public interface UserDao extends BaseMapper<TUser> {

    /**
     * 获取用户列表
     * @param paramsMap
     * @return
     */
    List<TUser> getUserList(@Param("map") Map<String, Object> paramsMap);

    TUser selectByMobile(@Param("mobile") String mobile);
}
