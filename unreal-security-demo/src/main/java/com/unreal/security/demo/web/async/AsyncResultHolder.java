package com.unreal.security.demo.web.async;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 15:50 2018/8/26
 */
@Component
@Data
public class AsyncResultHolder {
    private Map<String, DeferredResult<String>> deferredResultMap = new HashMap<>();
}
