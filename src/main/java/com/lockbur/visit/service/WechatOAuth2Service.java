package com.lockbur.visit.service;

import com.github.scribejava.core.oauth.OAuth20Service;
/**
 * 微信静默授权获取openID
 *
 * @author wangkun
 */
public interface WechatOAuth2Service {

    /**
     * 获取微信Oauth2的服务
     *
     * @return
     */
    public OAuth20Service getService();
}
