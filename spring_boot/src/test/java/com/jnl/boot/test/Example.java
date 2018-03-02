package com.jnl.boot.test;


public class Example {

	String name = "zhangsan";

	public Example(String name){
		System.out.println("初始化："+name);
		//this.name = name;
	}
	{
		System.out.println("代码块："+name);
		name = "lisi";
	}
	public static void main(String[] args){

		Example ex = new Example("wangermazi");
		System.out.println("ex :"+ex.name);
		Example ex2 = new Example("王五");
		System.out.println(ex2.name);
	}
	
	class Student{
		String  name;
		Student(String name){
			this.name = name;
		}
		public String toString(){
			return this.name;
		}
	}
}
