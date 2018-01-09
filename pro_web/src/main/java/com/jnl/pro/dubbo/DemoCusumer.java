package com.jnl.pro.dubbo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoCusumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:dubbo_consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // obtain proxy object for remote invocation
        String hello = demoService.sayHello("world"); // execute remote invocation
        System.out.println(hello); // show the result
    }
}
