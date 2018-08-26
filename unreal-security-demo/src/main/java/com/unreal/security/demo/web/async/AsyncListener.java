package com.unreal.security.demo.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 16:10 2018/8/26
 */
@Component
@Slf4j
public class AsyncListener implements ApplicationListener {

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private AsyncResultHolder asyncResultHolder;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        new Thread(() -> {
            while (true) {
                if (!StringUtils.isEmpty(mockQueue.getCompletionQueue())) {
                    String orderNumber = mockQueue.getCompletionQueue();
                    log.info("监听订单成功创建");
                    asyncResultHolder.getDeferredResultMap().get(orderNumber).setResult("order has been maked success!");
                    mockQueue.setCompletionQueue(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
