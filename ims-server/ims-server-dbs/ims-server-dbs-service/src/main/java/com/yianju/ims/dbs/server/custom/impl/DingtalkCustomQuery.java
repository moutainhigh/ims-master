package com.yianju.ims.dbs.server.custom.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserListbypageRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserListbypageResponse;
import com.taobao.api.ApiException;
import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.ims.dbs.server.custom.CustomQuery;
import com.yianju.ims.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


@Slf4j
public class DingtalkCustomQuery implements CustomQuery {
    @Override
    public BaseResponse execute(Map params){

        String CorpId = "ding559e4080d4d35b57";

        String AgentId = "331589946";

        String appkey = "dingx4pq1njxurldxenr";

        String appsecret = "RzdUuyEgy-kFcJ_dAWnRr_18Y7Nf6dcpN6VR-lWXyn-Ii3IIv9u0FjHY6st3Oqa6";

        String token_url = "https://oapi.dingtalk.com/gettoken?appkey=key&appsecret=secretaa";

        try{
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(appkey);
            request.setAppsecret(appsecret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);

            String accessToken = response.getAccessToken();

            log.info("获得accessToken信息为：{}",accessToken);


            DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/listbypage");
            OapiUserListbypageRequest request2 = new OapiUserListbypageRequest();
            request2.setDepartmentId(1L);
            request2.setOffset(0L);
            request2.setSize(10L);
            request2.setOrder("entry_desc");
            request2.setHttpMethod("GET");
            OapiUserListbypageResponse execute = client2.execute(request2,accessToken);

            List<OapiUserListbypageResponse.Userlist> userlist = execute.getUserlist();


            log.info(execute.getBody());
            return new BaseResponse(0,"请求成功",userlist);
        }catch (Exception e)
        {

        }


        return null;
    }
}
