package com.jnl.boot.test;


public class Example {

	static  Integer str = 1;//引用传递
	static  String str1 = "1";//引用传递
	static  char[] array = {'a','b','c'};//值传递
	static{
		
	}
	
	public void change(int str ,String[] array){
		str =2;
		array = new String[3];
		array[0]="d";
	}
	
	public static void main(String[] args){
		
		Integer int1 = 1;
		Integer int2 = 1;
		Integer hint1 = 129;
		Integer hint2 = 129;
		System.out.print(int1==int2);
		System.out.print(hint1==hint2);
		/*ex.change(ex.str,ex.array);*/
		
	/*	System.out.print(ex.str+"and");
		System.out.print(ex.array[0]);*/
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
