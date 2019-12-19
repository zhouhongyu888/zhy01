package com.atguigu.demo5;

/*
 * Volatile虽然可以保证线程之间的可见性，但是并不能保证一些变量操作的原子性
 */
class Thread01 extends Thread {
	public volatile boolean flag = true;

	@Override
	public void run() {
		System.out.println("开始执行子线程....");
		while (flag) {
		}
		System.out.println("线程停止");
	}

	public void setRuning(boolean flag) {
		this.flag = flag;
	}
}

public class VolatileDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread01 thread01 = new Thread01();
		thread01.setName("线程1");
		thread01.start();
		
		
		Thread.sleep(3000);
		
		
		
		thread01.setRuning(false);
		System.out.println("flag 已经设置成false");
		Thread.sleep(1000);
		System.out.println(thread01.flag);
	}
}
