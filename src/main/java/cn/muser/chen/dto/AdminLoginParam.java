package cn.muser.chen.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
/**
 * @ClassName AdminLoginParam
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/30 14:57
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class AdminLoginParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}

