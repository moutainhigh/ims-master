package com.yianju.ims.dbs.server.custom.impl;

import com.google.gson.Gson;
import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.ims.dbs.server.custom.CustomQuery;
import com.yianju.ims.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class WinXinCustomQuery implements CustomQuery {


    @Override
    public BaseResponse execute(Map params) {

        String token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET";

        String corpId = "wx97986f38325a7893";

        String corpsecret = "q_jRTY9ADakZL6SUk2JpRDOFtSpy-Yw7oaAtPbwa330";

        token_url = token_url.replace("ID",corpId).replace("SECRET",corpsecret);

        String s = HttpUtils.get(token_url);

        log.info("获得相应结果为：{}",s);

        //String t = "15:34:44.534 [main] INFO com.yianju.ims.dbs.server.custom.impl.DingtalkUserQuery - 获得相应结果为：{\"errcode\":0,\"errmsg\":\"ok\",\"access_token\":\"sREP8nNthuguFexbLtw6z93ae1RST2mS-eLa2OgNDa1w3eiZRYTlA7z3pPNKoWuYByefx9ZClO49asIvXr0FKGqLiceNK_TcNEPkQ0eOpPQvGhUGjOEcwCjoe1sf0lVqWWpbt0xjQ99h1VnxZt3nkJfHw4sc1UGehP6-oUfS1eOiIfCubVU7uH8GFRoD2-7MeEbCshGFgVO-glOILHUaCQ\",\"expires_in\":7200}";

        //String token = "sREP8nNthuguFexbLtw6z93ae1RST2mS-eLa2OgNDa1w3eiZRYTlA7z3pPNKoWuYByefx9ZClO49asIvXr0FKGqLiceNK_TcNEPkQ0eOpPQvGhUGjOEcwCjoe1sf0lVqWWpbt0xjQ99h1VnxZt3nkJfHw4sc1UGehP6-oUfS1eOiIfCubVU7uH8GFRoD2-7MeEbCshGFgVO-glOILHUaCQ";

        Gson gson = new Gson();

        HashMap hashMap = gson.fromJson(s, HashMap.class);


        String users_url = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD";

        users_url = users_url.replace("ACCESS_TOKEN",hashMap.get("access_token")+"")
                .replace("DEPARTMENT_ID","414")
                .replace("FETCH_CHILD","1");

        String s2 = HttpUtils.get(users_url);

        log.info(s2);

        HashMap hashMap1 = gson.fromJson(s2, HashMap.class);


        return new BaseResponse(0,"请求成功",hashMap1);
    }
}
