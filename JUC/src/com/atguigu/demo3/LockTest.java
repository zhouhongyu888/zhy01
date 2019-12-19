package com.atguigu.demo3;

/**
 * 对锁进行再说明：
 * 
 * 1.同一个对象 调用 两个同步方法 ： 执行完一个再执行另一个 
 * 2.两个对象 调用两个同步方法 ：交替执行。 
 * 3.同一个对象 调用两个静态同步方法 ：执行完一个再执行别一个 
 * 4.两个对象 调用两个静态同步方法 ： 执行完一个再执行别一个。 
 * 5.两个对象一个调用同步方法，一个调用静态同步方法 ： 交替执行
 */
class Computer {
	/**
	 * 锁 ：Computer.class
	 */
	public static synchronized void s1() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "=======" + i);
		}
	}

	/**
	 * 锁 : Class clazz =Computer.class
	 */
	public static synchronized void s2() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "********" + i);
		}
	}
	/**
	 * 锁 ：this
	 */
	public synchronized void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "=======" + i);
		}
	}

	/**
	 * 锁 : this
	 */
	public synchronized void run2() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "********" + i);
		}
	}
	
	
	public  void show() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "=======" + i);
		}
	}

	
	public  void show2() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "********" + i);
		}
	}

	
}

public class LockTest {

	public static void main(String[] args) {

		// Computer c = new Computer();
		// Computer c2 = new Computer();
		// c.getClass();
		// c2.getClass();
		// Computer.class();

		// Computer computer = new Computer();

		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// new Computer().s1();
		// }
		// },"AAA").start();
		//
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// new Computer().s2();
		// }
		// },"CCC").start();

		// ------------------------------------------------------------------------------------

//		Computer c = new Computer();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				c.s2();
//			}
//		}, "AAA").start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				c.run();
//			}
//		}, "CCC").start();
		

		// ------------------------------------------------------------------------------------
		
		Computer c = new Computer();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Computer().show();
			}
		}, "AAA").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				new Computer().show2();
			}
		}, "CCC").start();

	}
}
