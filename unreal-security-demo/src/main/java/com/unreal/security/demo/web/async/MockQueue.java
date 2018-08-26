package com.unreal.security.demo.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: JieMin
 * @Description:
 * @Date: created in 15:50 2018/8/26
 */

@Component
@Slf4j
public class MockQueue {
    private String holdingQueue;
    private String completionQueue;

    public String getHoldingQueue() {
        return holdingQueue;
    }

    public void setHoldingQueue(String holdingQueue) {
        new Thread(() -> {
            log.info("处理订单:" + holdingQueue);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completionQueue = holdingQueue;
            log.info("处理完成:" + holdingQueue);
        }).start();
    }

    public String getCompletionQueue() {
        return completionQueue;
    }

    public void setCompletionQueue(String completionQueue) {
        this.completionQueue = completionQueue;
    }

}
