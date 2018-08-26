package com.unreal.security.demo.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 21:37 2018/8/25
 */
//@Aspect
@Slf4j
@Component
public class TimeAspect {

    @Pointcut(value = "execution(* com.unreal.security.demo.web.controller.UserController.*(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public void around() {
        log.info("around");
    }
}
