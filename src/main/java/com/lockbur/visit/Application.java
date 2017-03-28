package com.lockbur.visit;

import com.lockbur.visit.config.AppConfig;
import com.lockbur.visit.config.DataSourceConfig;
import com.lockbur.visit.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * java config spring mvc mybatis No web.xml
 * Created by wangkun23 on 2017/3/28.
 */
public class Application extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class, WebConfig.class, DataSourceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
