package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WordsServiceImpl implements WordsService {

	@Autowired
	private WordsService wordsService;

	@Async
	@Override
	public void say(String word) {
		System.out.println(word);
	}

	@Override
	public void showWord(String word) {
		wordsService.say(word);
	}
}
