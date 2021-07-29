package cn.muser.chen.entry;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author ccs
 * @Date 2021/7/29 18:05
 **/
@Data
public class User implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码（密文）")
    private String pwd;

    @ApiModelProperty(value = "密码盐")
    private Integer pwdSalt;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "最后登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登录设备")
    private String lastLoginEqpt;

    @ApiModelProperty(value = "最后累计登录失败次数")
    private Integer lastFailedTimes;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "头像")
    private String headImg;

    @ApiModelProperty(value = "性别(F女、M男、N未知)")
    private String gender;

    @ApiModelProperty(value = "状态（VALID/FROZEN/DEL)")
    private String status;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private static final long serialVersionUID = 1L;


}
