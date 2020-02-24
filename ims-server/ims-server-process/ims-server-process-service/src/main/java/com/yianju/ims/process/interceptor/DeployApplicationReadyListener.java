package com.yianju.ims.process.interceptor;

import com.yianju.ims.server.process.model.CfProcessUnit;
import com.yianju.ims.server.process.service.ProcessUnitManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * 权限拦截器
 */
@WebListener
@Component
@Slf4j
public class DeployApplicationReadyListener implements ServletContextListener {

    @Autowired
    private ProcessUnitManager processUnitManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("开始启动部署");
        List<CfProcessUnit> runningProcessUnitList = processUnitManager.getRunningProcessUnit();
        for (CfProcessUnit unit: runningProcessUnitList) {
            processUnitManager.deploy(unit);
        }
        log.info("完成开机部署");
    }
}
