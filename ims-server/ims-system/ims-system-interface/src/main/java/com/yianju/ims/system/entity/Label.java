package com.yianju.ims.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户自定义信息
 */
@Data
@AllArgsConstructor
public class Label implements Serializable {
    private String key;
    private String label;
}
