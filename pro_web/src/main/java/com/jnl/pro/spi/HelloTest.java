package com.jnl.pro.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class HelloTest {
	public  static void main(String[] args){
		ServiceLoader<SayHello> helloLoader  = ServiceLoader.load(SayHello.class);
		  Iterator<SayHello> hellos = helloLoader.iterator();  
	        if (hellos.hasNext()) {  
	        	SayHello hello = hellos.next();  
	            hello.sayHello(); 
	        } 
	}
}
