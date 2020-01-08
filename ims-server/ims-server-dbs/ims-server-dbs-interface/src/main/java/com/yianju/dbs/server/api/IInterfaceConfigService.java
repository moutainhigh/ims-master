package com.yianju.dbs.server.api;

import com.yianju.dbs.server.entity.InterfaceConfig;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 接口信息配置
 */
@RequestMapping("/interfaceConfig")
public interface IInterfaceConfigService {

    /**
     * 保存查询配置信息
     * @param ic
     * @return
     */
    @RequestMapping("/save")
    public int savefaceConfig(InterfaceConfig ic);

}
