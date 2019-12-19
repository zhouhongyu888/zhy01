package com.atguigu.demo;


/**
	继承Thread和实现Runnable的区别是什么？
	1.开启多线程的方式上有区别。
		继承Thread如果要开启多个线程，创建多个Thread子类的对象
		实现Runnable接口，那么Runnable接口实现类的对象只需要创建一个。
	2.同步资源：
		继承Thread的方式，在Thread子类中声明的同步资源需要加static
		实现Runnable的方式，在Runnable实现类中声明的同步资源需不要加static
	3.同步监视器（多个线程的锁应该是同一把）：
		继承Thread的方式，同步监视器不能使用this
		实现Runnable的方式，同步监视器可以使用this
	4.同步方法：
		继承Thread的方式，同步方法必须加static (同步方法的隐式锁是 : 当前类.class 。如果不加static锁还是this)
		实现Runnable的方式，同步监视器可以使用this(同步方法的隐式锁是 : this)
		
		public static synchronized void test() {
		
		}
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		
	
	}
	
	
	
	/**
	 * 演示 继承Thhread和实现Runnable创建多线程的方式
	 */
	public void test2() {
		//实现Runnable
		Runnable r = () -> { //lambda表达式 就是 匿名内部类的一种简写方式（可以这么理解）
			
		};
		//开启分线程
		new Thread(r).start();
		new Thread(r).start();
		
		//创建了Thread的匿名子类的对象
		Thread t = new Thread() {
			public void run() {
				
			}
		};
		t.start();
		
		Thread t2 = new Thread() {
			public void run() {
				
			}
		};
		t.start();
	}
	
	/**
	 * 演示创建多线程的方式
	 */
	public void test() {
		//实现Runnable接口的方式
		new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		}).start();
		
		//----lambda表达式
		
		new Thread(() -> { 
			
		}) .start();
		
	}
}
