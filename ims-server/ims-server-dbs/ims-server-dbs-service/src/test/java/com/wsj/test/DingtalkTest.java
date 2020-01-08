package com.wsj.test;

import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.ims.dbs.server.custom.CustomQuery;
import com.yianju.ims.dbs.server.custom.impl.DingtalkCustomQuery;
import org.junit.Test;

import java.util.HashMap;

public class DingtalkTest {

    @Test
    public void test(){
        CustomQuery query = new DingtalkCustomQuery();
        BaseResponse execute = query.execute(new HashMap());


    }
}
