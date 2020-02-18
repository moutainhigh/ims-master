package com.yianju.ims.system.service.impl;

import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.service.impl.BaseManagerImpl;
import com.yianju.ims.system.entity.Label;
import com.yianju.ims.system.entity.Location;
import com.yianju.ims.system.entity.LoginRequestEntity;
import com.yianju.ims.system.entity.UserDetails;
import com.yianju.ims.system.model.ApiToken;
import com.yianju.ims.system.service.LoginManager;
import com.yianju.ims.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录管理
 */
@RestController
public class LoginManagerImpl extends BaseManagerImpl<ApiToken> implements LoginManager {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Result login(LoginRequestEntity request) {

        String type = request.getType();

        String mobile = request.getMobile();
        String password = request.getPassword();
        String username = request.getUsername();

        Map dataMap = new HashMap();
        dataMap.put("type",type);

        // loginType 1-账号密码登录，2为手机验证码登录
        if("account".equals(type)){
            ApiToken record = new ApiToken();
            record.setUsername(username);
            ApiToken apiToken = this.queryOne(record);

            if(apiToken==null){
                dataMap.put("message","用户不存在");
                return new Result(ResultCode.FAIL,dataMap);
            }

            String pwd = apiToken.getPassword();


            if(pwd.equals(password)){
                // 登录成功，加载token信息
                Map map = new HashMap();
                map.put("userId",apiToken.getId()+"");
                map.put("companyId",apiToken.getCompanyId());
                map.put("companyName",apiToken.getCompanyName());
                //map.put("appkey",apiToken.getAppkey());
                //map.put("appsecret",apiToken.getAppsecret());
                String jwt = jwtUtil.createJWT(apiToken.getId() + "", apiToken.getAppkey(), map);

                dataMap.put("access_token",jwt);
                dataMap.put("exp",7200);
                return new Result(ResultCode.SUCCESS,dataMap);
            }
        }


        dataMap.put("message","用户名或密码错误");

        return new Result(ResultCode.FAIL,dataMap);

    }

    @Override
    public UserDetails currentUser(HttpServletRequest request) {

        ApiToken record = new ApiToken();
        record.setRecStatus(0);
        record.setId(super.userId);
        ApiToken apiToken = this.queryOne(record);


        Label province = new Label("330000","浙江省");
        Label city = new Label("330100","杭州市");
        Location loc = new Location();
        loc.setCity(city);
        loc.setProvince(province);

        List<Label> list = new ArrayList<>();
        list.add(new Label("0","很有想法的"));
        list.add(new Label("1","专注设计"));
        list.add(new Label("2","辣~"));
        list.add(new Label("3","大长腿"));
        list.add(new Label("4","川妹子"));
        list.add(new Label("5","海纳百川"));
        list.add(new Label("6","可爱帅"));
        list.add(new Label("7","nice"));

        UserDetails user = new UserDetails();
        user.setAddress("北京市朝阳区东三环南路98号");
        user.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        user.setCountry("China");
        user.setEmail(apiToken.getEmail());
        user.setGeographic(loc);
        user.setGroup(companyName);
        user.setName(apiToken.getNickname());
        user.setNotifyCount(10);
        user.setPhone(apiToken.getMobile());
        user.setSignature("海纳百川，有容乃大");
        user.setTags(list);
        user.setUserid(apiToken.getId()+"");
        return user;
    }
}
