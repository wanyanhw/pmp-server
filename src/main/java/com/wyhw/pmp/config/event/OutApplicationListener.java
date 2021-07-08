package com.wyhw.pmp.config.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OutApplicationListener implements ApplicationListener<OutApplicationEvent> {
	@Override
	public void onApplicationEvent(OutApplicationEvent event) {
		System.out.println("收到事件：" + event.toString());
	}
}
