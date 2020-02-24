package com.yianju.ims.dbs.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yianju.dbs.server.api.InterfaceConfigManager;
import com.yianju.dbs.server.entity.InterfaceConfig;
import com.yianju.ims.constant.ImsConst;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.service.impl.BaseManagerImpl;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MrDuan
 * @since 2019-12-27
 */
@RestController
public class InterfaceConfigManagerImpl extends BaseManagerImpl<InterfaceConfig> implements InterfaceConfigManager {

    @Override
    public Result saveInterfaceConfig(InterfaceConfig ic) {
        int save = this.save(ic);
        if(save>0){
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public PageResult interfaceConfigList(JSONObject params) {
        String serviceName = params.getString("serviceName");
        Integer current = params.getInteger("current")==null?1:params.getInteger("current");
        Integer pageSize = params.getInteger("pageSize")==null?10:params.getInteger("pageSize");

        QueryWrapper<InterfaceConfig> queryWrapper = new QueryWrapper<InterfaceConfig>();

        queryWrapper.eq("rec_status", ImsConst.REC_OK);
        if(serviceName!=null && !"".equals(serviceName)){
            queryWrapper.eq("process_name",serviceName);
        }
        IPage<InterfaceConfig> page = this.queryPageList(queryWrapper, current, pageSize);
        return this.createPageResult(page);
    }
}
