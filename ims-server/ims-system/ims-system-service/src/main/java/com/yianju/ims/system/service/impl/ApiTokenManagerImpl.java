package com.yianju.ims.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.service.impl.BaseManagerImpl;
import com.yianju.ims.system.model.ApiToken;
import com.yianju.ims.system.service.ApiTokenManager;
import com.yianju.ims.util.BeanPropertyValidateUtil;
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
public class ApiTokenManagerImpl extends BaseManagerImpl<ApiToken> implements ApiTokenManager {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Result token(JSONObject params) {

        String corpId = params.get("corpId")==null ? null:params.get("corpId").toString();
        String appkey = params.get("appkey")==null ? null:params.get("appkey").toString();
        String appsecret = params.get("appsecret")==null ? null:params.get("appsecret").toString();
        if(StringUtils.isEmpty(corpId)){
            return new Result(ResultCode.VALIFIELD_NULL,"appsecret不能为空");
        }
        if(StringUtils.isEmpty(appkey)){
            return new Result(ResultCode.VALIFIELD_NULL,"appsecret不能为空");
        }
        if(StringUtils.isEmpty(appsecret)){
            return new Result(ResultCode.VALIFIELD_NULL,"appsecret不能为空");
        }
        ApiToken api = new ApiToken();
        api.setAppkey(appkey);
        api.setCorpId(corpId);
        api.setAppsecret(appsecret);
        ApiToken apiTokenFromDb = this.queryOne(api);

        if(apiTokenFromDb==null){
            return new Result(ResultCode.INVALID_TOKEN);
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

        return new Result(ResultCode.SUCCESS).setData(dataMap);
    }

    @Override
    public Result saveApiToken(ApiToken apiToken) {

        String username = apiToken.getUsername();
        Result validate = BeanPropertyValidateUtil.getEmptyFields(apiToken, "appkey", "username", "nickname", "mobile");
        if(!validate.isSuccess()){
            return validate;
        }

        // 生成appkey

        Integer save = this.save(apiToken);
        if(save<=0){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result updateApiToken(ApiToken apiToken) {
        Integer update = this.update(apiToken);
        if(update<=0){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result resetApiToken(ApiToken apiToken) {
        return updateApiToken(apiToken);
    }
}
