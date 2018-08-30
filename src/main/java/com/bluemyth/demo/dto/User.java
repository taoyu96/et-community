package com.bluemyth.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户实体")
public class User {
    @ApiModelProperty(value = "用户id")
    private String userid;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "邮箱")
    private String email;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ApiModelProperty(value = "状态")
    private Integer status;

}