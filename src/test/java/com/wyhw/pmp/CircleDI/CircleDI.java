package com.wyhw.pmp.CircleDI;

import com.wyhw.pmp.service.WordsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@EnableAsync
public class CircleDI {
	@Autowired
	private WordsService wordsService;
	@Test
	void testDI() {
		wordsService.showWord("hello world");
	}

}
