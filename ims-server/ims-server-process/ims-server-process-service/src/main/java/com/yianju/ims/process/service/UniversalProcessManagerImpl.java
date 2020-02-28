package com.yianju.ims.process.service;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.server.process.model.CfProcessUnit;
import com.yianju.ims.server.process.service.ImsDatabasesService;
import com.yianju.ims.server.process.service.ProcessUnitManager;
import com.yianju.ims.server.process.service.UniversalProcessManager;
import com.yianju.ims.server.process.service.core.AbstractProcessUnit;
import com.yianju.ims.server.process.service.core.ProcessUnit;
import com.yianju.ims.server.process.service.core.dynamic.DynamicClassLoader;
import com.yianju.ims.server.process.service.core.dynamic.DynamicClassLoaderManager;
import com.yianju.ims.service.impl.BaseManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 万能处理器实现类
 */
@RestController
@Slf4j
public class UniversalProcessManagerImpl extends BaseManagerImpl implements UniversalProcessManager {


    @Autowired
    private DynamicClassLoaderManager dynamicClassLoaderManager;

    @Autowired
    private ProcessUnitManager processUnitManager;

    @Autowired
    private ImsDatabasesService imsDatabasesService;
    /**
     * 动态classLoader容器
     */
    @Override
    public Result process(String processCode, JSONObject param) {

        Class<?> clz = null;
        try{

            // 1.通过配置获取处理的jar包
            CfProcessUnit processUnit = processUnitManager.getByProcessCode(processCode);

            // 2.实例化接口
            DynamicClassLoader dynamicClassLoader = dynamicClassLoaderManager.getDynamicClassLoader(processUnit.getProcessCode());
            clz = dynamicClassLoader.loadClass(processUnit.getStartDriver());
            Object instance = clz.newInstance();
            if(!(instance instanceof ProcessUnit)){
                log.info("非法处理单元，未实现ProcessUnit");
                throw new CommonException(ResultCode.ILLEGAL_PROCESS_UNIT);
            }

            ServletContext sc = this.request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
            ImsDatabasesService bean = webApplicationContext.getBean(ImsDatabasesService.class);
            if(instance instanceof AbstractProcessUnit){
                AbstractProcessUnit unit = (AbstractProcessUnit)instance;
                unit.setApplicationContext(webApplicationContext);
                return unit.process(param);
            }
            ProcessUnit unit = (ProcessUnit)instance;
            Result process = unit.process(param);
            log.info("执行成功");
            return process;

        }catch (CommonException e){
            return new Result(e.getResultCode(),e.getMessage());
        } catch (IllegalAccessException e) {
            return new Result(ResultCode.FAIL,e.getMessage());
        } catch (InstantiationException e) {
            return new Result(ResultCode.FAIL,e.getMessage());
        } catch (ClassNotFoundException e) {
            return new Result(ResultCode.FAIL,e.getMessage());
        }
    }

    @Override
    public Result feighTest(String service, JSONObject param) {
        return imsDatabasesService.query(service,param);
    }


}
