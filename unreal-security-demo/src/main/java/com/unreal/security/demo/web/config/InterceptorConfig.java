package com.unreal.security.demo.web.config;

import com.unreal.security.demo.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 16:51 2018/8/25
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TimeInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor);
    }
}
