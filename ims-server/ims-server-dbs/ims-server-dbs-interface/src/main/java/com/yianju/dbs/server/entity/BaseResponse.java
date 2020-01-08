package com.yianju.dbs.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基本返回实体
 */
@AllArgsConstructor
@Data
public class BaseResponse {
    private int state;
    private String message;
    private Object data;
}
