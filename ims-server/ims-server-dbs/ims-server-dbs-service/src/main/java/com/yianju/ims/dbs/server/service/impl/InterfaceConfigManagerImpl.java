package com.yianju.ims.dbs.server.service.impl;

import com.yianju.dbs.server.api.IInterfaceConfigService;
import com.yianju.dbs.server.entity.InterfaceConfig;
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
public class InterfaceConfigManagerImpl extends BaseManagerImpl<InterfaceConfig> implements IInterfaceConfigService {

    @Override
    public int savefaceConfig(InterfaceConfig ic){
        int save = this.save(ic);
        return save;
    }
}
