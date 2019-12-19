package com.atguigu.demo5;

import java.util.concurrent.atomic.AtomicInteger;

class Thread2 extends Thread {
	//volatile不保证原子性。
//	public static volatile int count;
	//可以使用AtomicInteger解决++不是原子性操作的问题
	public static AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			//因为底层操++操作的不是一步，那么多个线程操作时，就可能发生线程安全问题 ----（）
//			count++;
			count.incrementAndGet();//原子性操作
		}
	}
}

public class VolatileDemo2 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread2 thread2 = new Thread2();
			thread2.start();
		}
//		System.out.println("ccc");
		
		try {
			Thread.sleep(5000);//保证上面5个线程都执行完毕
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread2.count);
	}
}
