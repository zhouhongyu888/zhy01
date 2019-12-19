package com.atguigu.demo3;


class A{
	
}
public class ClassDemo {

	public static void main(String[] args) {
		
		Class clazz = A.class; //获取的运行时类的对象
		
		A a = new A();
		Class clazz2 = a.getClass();
		
		A b = new A();
		Class clazz3 = b.getClass();
		
		
		System.out.println(clazz == clazz2);
	}
}
