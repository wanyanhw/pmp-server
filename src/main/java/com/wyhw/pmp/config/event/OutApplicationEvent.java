package com.wyhw.pmp.config.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class OutApplicationEvent extends ApplicationEvent {

	@Getter
	@Setter
	private String data;

	public OutApplicationEvent(Object source, String data) {
		super(source);
		this.data = data;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
