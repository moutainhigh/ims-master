package com.yianju.dbs.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ApiToken extends BasePojo {

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


}
