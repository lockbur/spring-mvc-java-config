package com.lockbur.visit.controller;

import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.lockbur.visit.service.WechatOAuth2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 用户微信静默授权 请求授权地址和回调后获取access_token
 *
 * @author wangkun
 * @version 16/2/29
 */
@Controller
@RequestMapping("/oauth2")
public class OAuth2Controller {

    private static final Logger logger = LoggerFactory.getLogger(OAuth2Controller.class);
    private static final Token EMPTY_TOKEN = null;
    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";

    @Resource
    private WechatOAuth2Service wechatOAuth2Service;

    /**
     * 重构微信登录授权
     *
     * @param redirectUrl
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String redirectUrl, Model model) {
        OAuth20Service service = wechatOAuth2Service.getService();
        final String authorizationUrl = service.getAuthorizationUrl();
        logger.info("authorizationUrl login {}", authorizationUrl);
        return "redirect:" + authorizationUrl;
    }

    /**
     * @param state
     * @param code
     * @param model
     * @return
     * @ 微信回调地址 回调后获取到微信ID 在跳转到注册页面
     * @参照文档
     * @link http://mp.weixin.qq.com/wiki/4/9ac2e7b1f1d22e9e57260f6553822520.html
     * @link 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE
     */
    @RequestMapping("/github/callback")
    public String callback(String code, String state, Model model) {
        OAuth20Service service = wechatOAuth2Service.getService();
        logger.info("callBack code {}", code);
        logger.info("callBack state {}", state);
        try {
            final OAuth2AccessToken accessToken = service.getAccessToken(code);

            final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);

            service.signRequest(accessToken, request);

            final Response response = service.execute(request);
            logger.info("Got it! Lets see what we found...");

            logger.info("{}", response.getCode());
            logger.info("{}", response.getBody());
            logger.info("accessToken {}", accessToken);

        } catch (IOException | InterruptedException | ExecutionException ex) {
            logger.error("oauth_callback parse json error  {}", ex);
        }
        return "";
    }

    /**
     * 微信验证检查
     * 请填写接口配置信息，此信息需要你拥有自己的服务器资源。 填写的URL需要正确响应微信发送的Token验证
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @RequestMapping(value = "/wechatCheck", method = RequestMethod.GET)
    @ResponseBody
    public String wechatCheck(String signature, String timestamp, String nonce, String echostr) {
        logger.info("signature {}", signature);
        logger.info("timestamp {}", timestamp);
        logger.info("nonce {}", nonce);
        logger.info("echostr {}", echostr);
        return echostr;
    }

}
