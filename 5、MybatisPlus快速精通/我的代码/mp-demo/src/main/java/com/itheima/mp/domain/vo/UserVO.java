package com.itheima.mp.domain.vo;

import com.itheima.mp.domain.po.Userinfo;
import com.itheima.mp.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "用户VO实体")
public class UserVO {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("详细信息")
    private Userinfo info;

    @ApiModelProperty("使用状态（1正常 2冻结）")
    private UserStatus status;

    @ApiModelProperty("账户余额")
    private Integer balance;

    @ApiModelProperty("收货地址")
    private List<AddressVO> address;
}