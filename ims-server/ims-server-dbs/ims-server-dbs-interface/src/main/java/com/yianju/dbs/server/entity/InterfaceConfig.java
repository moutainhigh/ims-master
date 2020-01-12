package com.yianju.dbs.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yianju.ims.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author MrDuan
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class InterfaceConfig extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库连接ID
     */
    private Long dbConId;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 是否返回一行记录
     */
    private int isRetOne;

    /**
     * 服务编码
     */
    private String serviceCode;

    /**
     * 脚本
     */
    private String sqlText;



}
