package com.imooc.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DeferredResultHolder
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 21:00
 * @Version 1.0
 */
@Component
public class DeferredResultHolder {
    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
