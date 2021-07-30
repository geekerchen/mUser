package cn.muser.chen.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "t_user")
public class TUser implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "mobile")
    private String mobile;

    @ApiModelProperty(value = "密码（密文）")
    @TableField(value = "pwd")
    private String pwd;

    @ApiModelProperty(value = "密码盐")
    @TableField(value = "pwd_salt")
    private Integer pwdSalt;

    @ApiModelProperty(value = "最后登录时间")
    @TableField(value = "last_login_time")
    private Date lastLoginTime;

    @ApiModelProperty(value = "最后登录IP")
    @TableField(value = "last_login_ip")
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登录设备")
    @TableField(value = "last_login_eqpt")
    private String lastLoginEqpt;

    @ApiModelProperty(value = "最后累计登录失败次数")
    @TableField(value = "last_failed_times")
    private Integer lastFailedTimes;

    @ApiModelProperty(value = "昵称")
    @TableField(value = "nickname")
    private String nickname;

    @ApiModelProperty(value = "出生日期")
    @TableField(value = "birthday")
    private Date birthday;

    @ApiModelProperty(value = "头像")
    @TableField(value = "head_img")
    private String headImg;

    @ApiModelProperty(value = "性别(F女、M男、N未知)")
    @TableField(value = "gender")
    private String gender;

    @ApiModelProperty(value = "状态（VALID/FROZEN/DEL)")
    @TableField(value = "status")
    private String status;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "update_by")
    private Integer updateBy;

    @TableField(value = "pwd_salt")
    private static final long serialVersionUID = 1L;


}
