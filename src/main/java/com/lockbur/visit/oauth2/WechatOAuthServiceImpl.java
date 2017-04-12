package com.lockbur.visit.oauth2;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.oauth.OAuth20Service;

/**
 * 微信授权的实现，因为微信的参数时app_id 不是标准的
 * Created by wangkun23 on 2017/3/29.
 */
public class WechatOAuthServiceImpl extends OAuth20Service {

    public WechatOAuthServiceImpl(DefaultApi20 api, OAuthConfig config) {
        super(api, config);
    }

    @Override
    protected OAuthRequest createAccessTokenRequest(String code) {
        final DefaultApi20 api = getApi();

        final OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());

        final OAuthConfig config = getConfig();
//        request.addBodyParameter(OAuthConstants.CLIENT_ID, config.getApiKey());
        request.addBodyParameter("appid", config.getApiKey());
//        request.addBodyParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
        request.addBodyParameter("secret", config.getApiSecret());

        request.addBodyParameter(OAuthConstants.GRANT_TYPE, OAuthConstants.AUTHORIZATION_CODE);
        request.addBodyParameter(OAuthConstants.CODE, code);

        final String scope = config.getScope();
        if (scope != null) {
            request.addParameter(OAuthConstants.SCOPE, scope);
        }
        request.addParameter(OAuthConstants.REDIRECT_URI, config.getCallback());

        return request;
    }
}
