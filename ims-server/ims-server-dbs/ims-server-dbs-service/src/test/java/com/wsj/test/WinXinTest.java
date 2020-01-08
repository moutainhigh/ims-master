package com.wsj.test;

import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.ims.dbs.server.custom.CustomQuery;
import com.yianju.ims.dbs.server.custom.impl.WinXinCustomQuery;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WinXinTest {

    @Test
    public void getToken(){

        CustomQuery query = new WinXinCustomQuery();

        Map map = new HashMap();
        BaseResponse execute = query.execute(map);

    }
}
