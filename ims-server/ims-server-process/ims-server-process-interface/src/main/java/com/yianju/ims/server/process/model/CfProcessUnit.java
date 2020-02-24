package com.yianju.ims.server.process.model;


import com.yianju.ims.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 处理单元
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CfProcessUnit  extends BaseModel {

    /**
     * 处理单元编码
     */
    public String processCode;

    /**
     * 处理单元名称
     */
    public String processName;

    /**
     * 启动驱动
     */
    public String startDriver;

    /**
     * 文件位置
     */
    public String fileLocation;

    /**
     * 状态 DISABLE,ENABLE,RUNNING
     */
    public String state;

    /**
     * 功能描述
     */
    public String description;

    /**
     * 文件名称
     */
    public String fileName;
}
