package com.wyhw.pmp.jpa;

import com.wyhw.pmp.jpa.service.CustomTimer;

public class MainRunner {
	public static void main(String[] args) {
		CustomTimer timer = new CustomTimer();
//		timer.run();
//		timer.stop();
		timer.weakUp();
	}
}
