package com.yianju.ims.process.service;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.server.process.model.CfProcessUnit;
import com.yianju.ims.server.process.service.ProcessUnitManager;
import com.yianju.ims.server.process.service.UniversalProcessManager;
import com.yianju.ims.server.process.service.core.ProcessUnit;
import com.yianju.ims.server.process.service.core.dynamic.DynamicClassLoader;
import com.yianju.ims.server.process.service.core.dynamic.DynamicClassLoaderManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 万能处理器实现类
 */
@RestController
@Slf4j
public class UniversalProcessManagerImpl implements UniversalProcessManager {


    @Autowired
    private DynamicClassLoaderManager dynamicClassLoaderManager;

    @Autowired
    private ProcessUnitManager processUnitManager;

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
            Map<String, DynamicClassLoader> classLoaderMap = dynamicClassLoaderManager.getClassLoaderMap();
            System.out.println(classLoaderMap);
            DynamicClassLoader dynamicClassLoader = dynamicClassLoaderManager.getDynamicClassLoader(processUnit.getProcessCode());
            System.out.println(dynamicClassLoader);
            clz = dynamicClassLoader.loadClass(processUnit.getStartDriver());
            // Constructor<?> constructor = clz.getConstructor(String.class);
            // Object content = constructor.newInstance("content");
            Object instance = clz.newInstance();
            if(!(instance instanceof ProcessUnit)){
                log.info("非法处理单元，未实现ProcessUnit");
                throw new CommonException(ResultCode.ILLEGAL_PROCESS_UNIT);
            }

            ProcessUnit unit = (ProcessUnit)instance;

            unit.process(param);

            log.info("执行成功");


        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
