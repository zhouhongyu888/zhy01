package com.atguigu.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的第三种方式 ： 实现Callable接口
 * 
 * 特点 ： 有返回值
 */
public class CallableTest {

	public void test() {
		List<Integer> list = new ArrayList<>();

		// 分线程作用装10个数：
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					list.add(i);
					System.out.println(Thread.currentThread().getName() + "------");
				}
			}
		}).start();

		// 主线程获取这10个数
		System.out.println(list.size());
	}

	public static void main(String[] args) throws Exception, Exception {
		// new CallableTest().test();

		// 4.创建Callable接口的实现类的对象
		MyCallable myCallable = new MyCallable();
		// 5.创建FutureTask对象，并将Callable接口的实现类的对象作为实参传递到FutureTask构造器中
		FutureTask<String> ft = new FutureTask<String>(myCallable);
		// 6.创建Thread对象并将FutureTask对象作为实参传递到Thread构造器中
		Thread t = new Thread(ft);
		// 7.调用start方法
		t.start();

		// 再开启一个分线程
		FutureTask<String> ft2 = new FutureTask<String>(myCallable);
		Thread t2 = new Thread(ft2);
		t2.start();

		// 获取线程的返回值
		String s = ft.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft分线程返回的结果为:" + s);
		
		
		String s2 = ft2.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft2分线程返回的结果为:" + s2);
		//注意 ： 同一个线程调用多次get方法，第二次开始获取的值都是从缓存中获取的。
		String s3 = ft2.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft2分线程返回的结果为:" + s3);
		String s4 = ft2.get();// 执行该方法时会阻塞当前线程
		System.out.println("ft2分线程返回的结果为:" + s4);
	

//		for (int i = 0; i < 10; i++) {
//			System.out.println(Thread.currentThread().getName() + "====" + i);
//		}

	}
}

// 1.创建一个类并实现Callable接口
class MyCallable implements Callable<String> {

	// 2.重写call方法
	@Override
	public String call() throws Exception {
		// 3.在call方法中实现需要在分线程中实现的功能
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "====" + i);
		}
		return Math.random() + "";
	}

}
