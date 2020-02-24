package com.yianju.ims.server.process.service;


import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import com.yianju.ims.server.process.model.CfProcessUnit;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 处理单元管理器
 */
public interface ProcessUnitManager {

    /**
     * 添加处理单元
     * @param unit
     * @return
     */
    @RequestMapping(value = "/addProcessUnit",method = RequestMethod.POST)
    public Result addProcessUnit(@RequestBody CfProcessUnit unit);


    /**
     * 删除处理单元
     * @param unit
     * @return
     */
    @RequestMapping(value = "/deleteProcessUnit",method = RequestMethod.DELETE)
    public Result deleteProcessUnit(@RequestBody CfProcessUnit unit);

    /**
     * 更新处理单元
     * @param unit
     * @return
     */
    @RequestMapping(value = "/updateProcessUnit",method = RequestMethod.PUT)
    public Result updateProcessUnit(@RequestBody CfProcessUnit unit);

    /**
     * 处理单元列表
     * @param params
     * @return
     */
    @RequestMapping(value = "/processUnitList",method = RequestMethod.POST)
    public PageResult processUnitList(@RequestBody JSONObject params);

    /**
     * 部署
     * @param unit
     * @return
     */
    @RequestMapping(value = "/deploy",method = RequestMethod.POST)
    public Result deploy(@RequestBody CfProcessUnit unit);

    /**
     * 解除部署
     * @param unit
     * @return
     */
    @RequestMapping(value = "/unDeploy",method = RequestMethod.POST)
    public Result unDeploy(@RequestBody CfProcessUnit unit);

    /**
     * 获取 CfProcessUnit
     * @param processCode
     * @return
     */
    public CfProcessUnit getByProcessCode(String processCode);


    /**
     * 获取运行状态的处理单元
     * @return
     */
    public List<CfProcessUnit> getRunningProcessUnit();
}
