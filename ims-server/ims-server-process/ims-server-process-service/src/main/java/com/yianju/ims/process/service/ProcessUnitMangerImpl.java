package com.yianju.ims.process.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yianju.ims.constant.ImsConst;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.server.process.model.CfProcessUnit;
import com.yianju.ims.server.process.service.ProcessUnitManager;
import com.yianju.ims.server.process.service.core.dynamic.DynamicClassLoaderManager;
import com.yianju.ims.service.impl.BaseManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@Slf4j
public class ProcessUnitMangerImpl extends BaseManagerImpl<CfProcessUnit> implements ProcessUnitManager {

    @Autowired
    private DynamicClassLoaderManager dynamicClassLoaderManager;

    @Override
    public Result addProcessUnit(CfProcessUnit unit) {

        // 校验 processCode不能重复，location不能一样
        List<CfProcessUnit> listByCode = this.queryListByWhere(new CfProcessUnit().setProcessCode(unit.getProcessCode()));

        if(listByCode.size()>0){
            return new Result(ResultCode.FAIL,"处理单元编码不能重复");
        }

        List<CfProcessUnit> listByLocation = this.queryListByWhere(new CfProcessUnit().setProcessCode(unit.getFileLocation()));

        if(listByLocation.size()>0){
            return new Result(ResultCode.FAIL,"处理单元编码不能重复");
        }

        unit.setState("ENABLE");

        Integer save = this.save(unit);

        if(save>0){
            return new Result(ResultCode.SUCCESS);
        }

        return new Result(ResultCode.FAIL,"保存失败");
    }

    @Override
    public Result deleteProcessUnit(CfProcessUnit unit) {
        Long id = unit.getId();
        this.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result updateProcessUnit(CfProcessUnit unit) {
        this.update(unit);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public PageResult processUnitList(JSONObject json) {
        String processName = json.getString("processName");
        String state = json.getString("state");
        Integer current = json.getInteger("currentPage")==null?1:json.getInteger("currentPage");
        Integer pageSize = json.getInteger("pageSize")==null?10:json.getInteger("pageSize");

        QueryWrapper<CfProcessUnit> queryWrapper = new QueryWrapper<CfProcessUnit>();

        queryWrapper.eq("rec_status", ImsConst.REC_OK);
        if(processName!=null && !"".equals(processName)){
            queryWrapper.eq("process_name",processName);
        }
        if(state!=null && !"".equals(state)){
            queryWrapper.eq("state",state);
        }
        IPage<CfProcessUnit> cfProcessUnitIPage = this.queryPageList(queryWrapper, current, pageSize);
        return this.createPageResult(cfProcessUnitIPage);

    }

    @Override
    public Result deploy(CfProcessUnit unit) {
        try {
            dynamicClassLoaderManager.deploy(unit.getProcessCode(),unit.getFileLocation());
            unit.setState("RUNNING");
            this.update(unit);
            log.info("成功部署应用单元：{},{}",unit.processCode,unit.processName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new Result(ResultCode.FAIL,e.getMessage());
        }
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result unDeploy(CfProcessUnit unit) {
        dynamicClassLoaderManager.unDeploy(unit.getProcessCode());
        unit.setState("DISABLE");
        this.update(unit);
        log.info("成功卸载应用单元：{},{}",unit.processCode,unit.processName);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public CfProcessUnit getByProcessCode(String processCode) {
        return this.queryOne(new CfProcessUnit().setProcessCode(processCode));
    }

    @Override
    public List<CfProcessUnit> getRunningProcessUnit() {
        return this.queryListByWhere(new CfProcessUnit().setState("RUNNING"));
    }
}
