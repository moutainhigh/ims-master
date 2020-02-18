package com.yianju.ims.system.model;

import com.yianju.ims.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiToken extends BaseModel {

    /**
     * 企业名称
     */
    private String corpId;

    /**
     * appkey
     */
    private String appkey;

    /**
     * 秘钥
     */
    private String appsecret;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 关联账号ID
     */
    private String linkAccountId;

    /**
     * 关联账号
     */
    private String linkAccountName;


}
