package com.yianju.dbs.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author MrDuan
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DbConnection extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 连接名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 数据库类型：0 Oracle 1 MySQL 2 MS Sql Server
     */
    private String dbtype;

    /**
     * 连接地址
     */
    private String url;

    /**
     * 数据库用户
     */
    private String user;

    private String password;

}
