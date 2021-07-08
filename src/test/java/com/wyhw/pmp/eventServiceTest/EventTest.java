package com.wyhw.pmp.eventServiceTest;

import com.wyhw.pmp.config.event.OutApplicationEvent;
import com.wyhw.pmp.config.event.OutEventPublisher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventTest {
	@Autowired
	OutEventPublisher publisher;

	@Test
	void testPub() {
		publisher.publishEvent(new OutApplicationEvent(this, "新发布事件"));
	}
}
