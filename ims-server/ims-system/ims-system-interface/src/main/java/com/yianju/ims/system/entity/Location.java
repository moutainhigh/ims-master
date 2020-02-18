package com.yianju.ims.system.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户详情，用户位置所在城市
 */
@Data
public class Location implements Serializable {

    private Label province;
    private Label city;
}


