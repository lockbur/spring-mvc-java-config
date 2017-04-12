package com.lockbur.visit.service.impl;

import com.github.scribejava.apis.GitHubApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.lockbur.visit.oauth2.WechatApi20;
import com.lockbur.visit.service.WechatOAuth2Service;
import org.springframework.stereotype.Service;

/**
 * 微信授权认证
 * Created by wangkun23 on 2017/3/28.
 */
@Service
public class WechatOAuth2ServiceImpl implements WechatOAuth2Service {

    private OAuth20Service service;

    /**
     * @return
     * @ 设置微信的配置信息
     * @ 从配置文件读取配置信息
     */
    @Override
    public OAuth20Service getService() {
        if (service == null) {
            service = new ServiceBuilder()
                    .apiKey("wx196f86cdd6bd4221")
                    .apiSecret("a1c61cb626ac281b314de7be779e2d20")
                    .callback("http://weixin.lockbur.com/oauth2/wechat/callback")
                    .scope("snsapi_login")
//                    .scope("snsapi_base")
                    .build(WechatApi20.instance());
//            service = new ServiceBuilder()
//                    .apiKey("e5071c636fc233d8a8c6")
//                    .apiSecret("0fb4c03145b812596cc05bff459678affdc87ba3")
//                    .callback("http://www.lockbur.com/oauth2/github/callback")
//                    .build(GitHubApi.instance());
        }
        return service;
    }
}
