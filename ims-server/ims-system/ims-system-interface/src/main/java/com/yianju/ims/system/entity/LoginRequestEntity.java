package com.yianju.ims.system.entity;

import lombok.Data;

/**
 * 登录请求实体
 */
@Data
public class LoginRequestEntity {

    private String username;
    private String mobile;
    private String password;
    private String type;

}
