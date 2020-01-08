package com.yianju.ims.dbs.server.token;

import com.alibaba.fastjson.JSONObject;
import com.yianju.dbs.server.api.ApiTokenServer;
import com.yianju.dbs.server.entity.ApiToken;
import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.ims.dbs.server.service.impl.BaseServiceImpl;
import com.yianju.ims.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * token 服务
 */
@RestController
public class TokenServiceImpl extends BaseServiceImpl<ApiToken> implements ApiTokenServer {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public BaseResponse token(JSONObject params) {

        String corpId = params.get("corpId")==null ? null:params.get("corpId").toString();
        String appkey = params.get("appkey")==null ? null:params.get("appkey").toString();
        String appsecret = params.get("appsecret")==null ? null:params.get("appsecret").toString();
        if(StringUtils.isEmpty(corpId)){
            return new BaseResponse(-1,"corpId不能为空","");
        }
        if(StringUtils.isEmpty(appkey)){
            return new BaseResponse(-1,"appkey不能为空","");
        }
        if(StringUtils.isEmpty(appsecret)){
            return new BaseResponse(-1,"appsecret不能为空","");
        }
        ApiToken api = new ApiToken();
        api.setAppkey(appkey);
        api.setCorpId(corpId);
        api.setAppsecret(appsecret);
        ApiToken apiTokenFromDb = this.queryOne(api);

        if(apiTokenFromDb==null){
            return new BaseResponse(-1,"无效的appsecret","");
        }

        Map map = new HashMap();
        map.put("id",apiTokenFromDb.getId());
        map.put("corpId",corpId);
        map.put("appkey",appkey);
        map.put("appsecret",appsecret);
        String jwt = jwtUtil.createJWT(apiTokenFromDb.getId() + "", appkey, map);

        Map dataMap = new HashMap();
        dataMap.put("access_token",jwt);
        dataMap.put("exp",7200);
        return new BaseResponse(0,"请求成功",dataMap);
    }

    @Override
    public BaseResponse saveApiToken(ApiToken apiToken) {
        Integer save = this.save(apiToken);
        if(save<=0){
            return new BaseResponse(-1,"保存失败",null);
        }
        return new BaseResponse(0,"保存成功",null);
    }

    @Override
    public BaseResponse updateApiToken(ApiToken apiToken) {
        Integer update = this.update(apiToken);
        if(update<=0){
            return new BaseResponse(-1,"更新失败",null);
        }
        return new BaseResponse(0,"更新成功",null);
    }

    @Override
    public BaseResponse resetApiToken(ApiToken apiToken) {
        return updateApiToken(apiToken);
    }
}
