package com.arloor.zhang.controller;

import com.arloor.zhang.model.OpenId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.appsecret}")
    private String appsecret;


    @ApiOperation(value = "获取openid",produces ="{\"errcode\":40163,\"errmsg\":\"code been used, hints: [ req_id: UgBK705832036 ]\"}或者 {\"session_key\":\"Ts6CSygilgmRdvDc4FD1kg==\",\"openid\":\"oSL165bqhPyJ4HNz3KQmx7N8SYX0\"}")
    @RequestMapping("/openId")
    public ResponseEntity<String> openId(@ApiParam(value = "wx.login产生的js_code",required = true) @RequestParam String js_code){
        String getUrl=String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&grant_type=authorization_code&js_code=%s",appid,appsecret,js_code);
        return restTemplate.getForEntity(getUrl,String.class);
    }
}
