package com.jnl.pro.spi;

import java.util.Iterator;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public  class  HelloTest {

	/**定义一个可分解的的任务类，继承了RecursiveAction抽象类
	 * 必须实现它的compute方法
	 */
	public static class myTask extends RecursiveAction {

		private static final long serialVersionUID = 1L;
		//定义一个分解任务的阈值——50,即一个任务最多承担50个工作量
		int THRESHOLD=50;
		//任务量
		int task_Num=0;
		myTask(int Num){
			this.task_Num=Num;
		}
		@Override
		protected void compute() {
			if(task_Num<=THRESHOLD){
				System.out.println(Thread.currentThread().getName()+"承担了"+task_Num+"份工作");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				//随机解成两个任务
				Random m=new Random();
				int x=m.nextInt(50);
				System.out.println(x);
				myTask left=new myTask(x);
				myTask right=new myTask(task_Num-x);

				left.fork();
				right.fork();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//创建一个支持分解任务的线程池ForkJoinPool
		int[] array = new int[30];
		for(int i = 0; i<array.length; i++){
			array[i] = i;
		}
		Thread.sleep(999999999);
		for(int i = 0; i<array.length; i++){
			System.out.print(i);
		}
	}

	/*
	public  static void main(String[] args){
		ServiceLoader<SayHello> helloLoader  = ServiceLoader.load(SayHello.class);
		  Iterator<SayHello> hellos = helloLoader.iterator();  
	        if (hellos.hasNext()) {  
	        	SayHello hello = hellos.next();  
	            hello.sayHello(); 
	        } 
	}*/
}
