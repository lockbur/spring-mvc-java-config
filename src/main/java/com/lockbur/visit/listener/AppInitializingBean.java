package com.lockbur.visit.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author wangkun23
 */
@Component
public class AppInitializingBean implements InitializingBean {

    final Logger logger = LoggerFactory.getLogger(AppInitializingBean.class);

    @Autowired
    private Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("build.version={}", env.getProperty("build.version"));
        logger.info("build.timestamp={}", env.getProperty("build.timestamp"));
    }
}
