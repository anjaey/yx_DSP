package com.hy.develop.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Load implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
    	if(evt.getApplicationContext().getParent() == null){
    		
       }
    }
}