package cn.muser.chen.bo;

import cn.muser.chen.entry.TUser;
import lombok.Data;

/**
 * @ClassName MyUser
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/30 14:15
 **/
@Data
public class MyUser extends TUser {
    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
