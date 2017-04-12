package com.lockbur.visit.oauth2;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import java.util.Map;
/**
 * 设置微信Oauth2请求的相关链接
 *
 * @author wangkun23
 */
public class WechatApi20 extends DefaultApi20 {

    protected WechatApi20() {
    }

    private static class InstanceHolder {
        private static final WechatApi20 INSTANCE = new WechatApi20();
    }

    public static WechatApi20 instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return OAuth2AccessTokenJsonExtractor.instance();
    }

    @Override
    public String getAccessTokenEndpoint() {
        //请求获取access_token地址
        return "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=" + OAuthConstants.AUTHORIZATION_CODE;
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config, Map<String, String> additionalParams) {
        final ParameterList parameters = new ParameterList(additionalParams);

        parameters.add(OAuthConstants.RESPONSE_TYPE, config.getResponseType());
//      parameters.add(OAuthConstants.CLIENT_ID, config.getApiKey());
        parameters.add("appid", config.getApiKey());

        final String callback = config.getCallback();
        if (callback != null) {
            parameters.add(OAuthConstants.REDIRECT_URI, callback);
        }

        final String scope = config.getScope();
        if (scope != null) {
            parameters.add(OAuthConstants.SCOPE, scope);
        }

        final String state = config.getState();
        if (state != null) {
            parameters.add(OAuthConstants.STATE, state);
        }
        //授权请求地址
       // return parameters.appendTo("https://open.weixin.qq.com/connect/oauth2/authorize");
       //扫码登录
        return parameters.appendTo("https://open.weixin.qq.com/connect/oauth2/authorize");
    }

    @Override
    public OAuth20Service createService(OAuthConfig config) {
        return new WechatOAuthServiceImpl(this, config);
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        throw new UnsupportedOperationException("use getAuthorizationUrl instead");
    }
}
