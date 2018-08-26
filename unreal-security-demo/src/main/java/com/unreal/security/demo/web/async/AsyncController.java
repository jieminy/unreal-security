package com.unreal.security.demo.web.async;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 15:49 2018/8/26
 */
@RestController
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncResultHolder asyncResultHolder;

    @Autowired
    private MockQueue mockQueue;

    @GetMapping("/order")
    public DeferredResult<String> order() {
        log.info("主线程开始");
        String orderNumber = RandomString.make(8);
        mockQueue.setHoldingQueue(orderNumber);

        DeferredResult<String> deferredResult = new DeferredResult<>();
        asyncResultHolder.getDeferredResultMap().put(orderNumber, deferredResult);
        return deferredResult;
    }
}
