package com.unreal.security.demo.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 19:45 2018/8/18
 */
@Slf4j
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TimeFilter initialization ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("TimeFilter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        log.info("used time: {} ms", new Date().getTime() - start);
        log.info("TimeFilter finish");
    }

    @Override
    public void destroy() {
        log.info("TimeFilter destroy ");
    }
}
