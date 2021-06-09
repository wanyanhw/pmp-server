package com.wyhw.pmp.jpa.service;

import com.wyhw.pmp.util.DateUtil;

import java.time.LocalDateTime;

public class CustomTimer implements Runnable {
	@Override
	public void run() {
		System.out.println(LocalDateTime.now().format(DateUtil.STANDARD_DATE));
	}
	public synchronized void stop() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void weakUp() {
		notify();
	}
}
